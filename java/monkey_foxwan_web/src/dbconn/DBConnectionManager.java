package dbconn;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

//建立DBConnectionManager
public class DBConnectionManager {
	static private DBConnectionManager instance;
	static private int clients;

	private Vector<Driver> drivers = new Vector<Driver>();
	private static PrintWriter log;
	private Hashtable<String, DBConnectionPool> pools = new Hashtable<String, DBConnectionPool>();

	// 返回唯一的实列
	static synchronized public DBConnectionManager getInstance() {
		if (instance == null) {
			instance = new DBConnectionManager();
		}
		clients++;
		return instance;
	}

	// 构造函数！
	public DBConnectionManager() {
		init();
	}

	// 释放一个连接
	public void freeConnection(String name, Connection con) {
		DBConnectionPool pool = (DBConnectionPool) pools.get(name);
		if (pool != null) {
			pool.freeConnection(con);
		}
	}

	// 结束释放一个连接

	// 取得一个连接
	public Connection getConnection(String name) {
		//System.out.println("getConnection:name:" + name);
		DBConnectionPool pool = (DBConnectionPool) pools.get(name);
		//System.out.println("pools:" + pools.size() + "   name:" + pool.getName() + "  url:" + pools.toString());
		if (pool != null) {
			return pool.getConnection();
		}
		return null;
	}

	public Connection getConnection(String name, String customer) {
		DBConnectionPool pool = (DBConnectionPool) pools.get(name);
		if (pool != null) {
			return pool.getConnection(customer);
		}
		return null;
	}

	public Connection getConnection(String name, long time) {
		DBConnectionPool pool = (DBConnectionPool) pools.get(name);
		if (pool != null) {
			return pool.getConnection(time);
		}
		return null;
	}

	// 结束getconnection
	// 关闭所有连接
	public synchronized void release() {
		// if(--clients!=0)
		// return;

		Enumeration<DBConnectionPool> allPools = pools.elements();
		while (allPools.hasMoreElements()) {
			DBConnectionPool pool = (DBConnectionPool) allPools.nextElement();
			pool.release();
		}
		Enumeration<Driver> allDrivers = drivers.elements();
		while (allDrivers.hasMoreElements()) {
			Driver driver = (Driver) allDrivers.nextElement();
			try {
				DriverManager.deregisterDriver(driver);
				log("撤消JDBC驱动程序" + driver.getClass().getName());
			} catch (SQLException e) {
				log(e, "无法撤消JDBC驱动程序的注册" + driver.getClass().getName());
			}
		}
	}

	public synchronized void release(String customer) {
		Enumeration<DBConnectionPool> allPools = pools.elements();
		while (allPools.hasMoreElements()) {
			DBConnectionPool pool = (DBConnectionPool) allPools.nextElement();
			pool.release(customer);
		}
		Enumeration<Driver> allDrivers = drivers.elements();
		while (allDrivers.hasMoreElements()) {
			Driver driver = (Driver) allDrivers.nextElement();
			try {
				DriverManager.deregisterDriver(driver);
				log(customer + "撤消JDBC驱动程序" + driver.getClass().getName());
			} catch (SQLException e) {
				log(e, "无法撤消JDBC驱动程序的注册" + driver.getClass().getName());
			}
		}
	}

	private void createPools(Properties props) {
		Enumeration<?> propNames = props.propertyNames();
		while (propNames.hasMoreElements()) {
			String name = (String) propNames.nextElement();
			if (name.endsWith(".url")) {
				String poolName = name.substring(0, name.lastIndexOf("."));
				String url = props.getProperty(poolName + ".url");
				//System.out.println("url:" + url);
				if (url == null) {
					log("没有连接池" + poolName + "指定的URL");
					continue;
				}
				String user = props.getProperty(poolName + ".user");
				//System.out.println("user:" + user);
				String password = props.getProperty(poolName + ".password");
				//System.out.println("password:" + password);
				String maxconn = props.getProperty(poolName + ".maxconn", "0");
				int max;
				try {
					max = Integer.valueOf(maxconn).intValue();
				} catch (NumberFormatException e) {
					log("错误的最大连接数：" + maxconn + ".连接池" + poolName);
					max = 0;
				}
				DBConnectionPool pool = new DBConnectionPool(poolName, url,
						user, password, max);
				//System.out.println("poolName:" + poolName + " url:" + url + " user:" + user + " password:" + password + " max:" + max);
				pools.put(poolName, pool);
				//System.out.println("成功创建连接池" + poolName);
				log("成功创建连接池" + poolName);
			}
		}
	}

	private void init() {
		InputStream is = getClass().getResourceAsStream("db.properties");
		Properties dbProps = new Properties();
		try {
			dbProps.load(is);
		} catch (Exception e) {
			System.err.println("不能读取属性文件。请确保db.properties在你的CLASSPATH中");
			return;
		}
		String logFile = dbProps.getProperty("logfile", "DBConnectionManager.log");
		try {
			log = new PrintWriter(new FileWriter(logFile, true), true);
		} catch (IOException e) {
			System.err.println("无法打开日志文件：" + logFile);
			log = new PrintWriter(System.err);
		}
		loadDriver(dbProps);
		createPools(dbProps);
	}

	private void loadDriver(Properties props) {
		String driverClasses = props.getProperty("drivers");
		StringTokenizer st = new StringTokenizer(driverClasses);
		while (st.hasMoreElements()) {
			String driverClassName = st.nextToken().trim();
			try {
				Driver driver = (Driver) Class.forName(driverClassName)
						.newInstance();
				DriverManager.registerDriver(driver);
				drivers.addElement(driver);
				log("成功注册驱动程序" + driverClassName);
			} catch (Exception e) {
				log("无法注册驱动程序:" + driverClassName + ",错误" + e);
			}
		}
	}

	public static void log(String msg) {
		log.println(new Date() + ":" + msg);
	}

	public static void log(Throwable e, String msg) {
		log.println(new Date() + ":" + msg);
		e.printStackTrace(log);
	}
}

class DBConnectionPool {
	private int checkOut;
	private Vector freeConnections = new Vector();
	private int maxconn;
	private String name;
	private String password;
	private String URL;
	private String user;

	public String getName(){
		return name + URL;
	}
	
	public DBConnectionPool(String name, String URL, String user,
			String password, int maxconn) {
		this.name = name;
		this.URL = URL;
		this.password = password;
		this.user = user;
		this.maxconn = maxconn;
	}

	public synchronized void freeConnection(Connection con) {
		freeConnections.addElement(con);
		checkOut--;
		notifyAll();
	}

	public synchronized Connection getConnection() {
		Connection con = null;
		//System.out.println("freeConnection.size:" + freeConnections.size());
		//System.out.println("maxconn:" + maxconn + " checkOut:" + checkOut);
		if (freeConnections.size() > 0) {
			con = (Connection) freeConnections.firstElement();
			freeConnections.removeElementAt(0);
			try {
				if (con.isClosed()) {
					DBConnectionManager.log("从连接池" + name + "删除一个连接");
					//System.out.println("从连接池" + name + "删除一个连接");
					con = getConnection();
				}
			} catch (SQLException e) {
				DBConnectionManager.log("从连接池" + name + "删除一个连接");
				//System.out.println("从连接池" + name + "删除一个连接");
				con = getConnection();
			}
		} else if (maxconn == 0 || checkOut < maxconn) {
			con = newConnection();
		}
	//	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + "maxconn:" + maxconn + " checkOut:" + checkOut);
		if (con != null) {
			checkOut++;
		}
		return con;
	}

	public synchronized Connection getConnection(String customer) {
		Connection con = null;
		if (freeConnections.size() > 0) {
			con = (Connection) freeConnections.firstElement();
			freeConnections.removeElementAt(0);
			try {
				if (con.isClosed()) {
					DBConnectionManager.log("从连接池" + name + "删除一个连接");
					con = getConnection();
				}
			} catch (SQLException e) {
				DBConnectionManager.log("从连接池" + name + "删除一个连接");
				con = getConnection();
			}
		} else if (maxconn == 0 || checkOut < maxconn) {
			con = newConnection(customer);
		}
		if (con != null) {
			checkOut++;
		}
		return con;
	}

	public synchronized Connection getConnection(long timeout) {
		long startTime = new Date().getTime();
		Connection con;
		while ((con = getConnection()) == null) {
			try {
				wait(timeout);
			} catch (InterruptedException e) {
			}
			if ((new Date().getTime() - startTime) >= timeout) {
				return null;
			}
		}
		return con;
	}

	public void release() {
		Enumeration allConnections = freeConnections.elements();
		while (allConnections.hasMoreElements()) {
			Connection con = (Connection) allConnections.nextElement();
			try {
				con.close();
				DBConnectionManager.log("关闭连接池" + name + "中的连接");
			} catch (SQLException e) {
				DBConnectionManager.log(e, "无法关闭连接池" + name + "中的连接");
			}
		}
		freeConnections.removeAllElements();
	}

	public void release(String customer) {
		Enumeration allConnections = freeConnections.elements();
		while (allConnections.hasMoreElements()) {
			Connection con = (Connection) allConnections.nextElement();
			try {
				con.close();
				DBConnectionManager.log(customer + "关闭连接池" + name + "中的连接");
			} catch (SQLException e) {
				DBConnectionManager.log(e, "无法关闭连接池" + name + "中的连接");
			}
		}
		freeConnections.removeAllElements();
	}

	private Connection newConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, user, password);
			DBConnectionManager.log("连接池" + name + "创建一个新的连接");
		} catch (SQLException e) {
			DBConnectionManager.log(e, "无法创建下列URL的连接" + URL);
			return null;
		}
		return con;
	}

	private Connection newConnection(String customer) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, user, password);
			DBConnectionManager.log(customer + "从连接池" + name + "创建一个新的连接");
		} catch (SQLException e) {
			DBConnectionManager.log(e, "无法创建下列URL的连接" + URL);
			return null;
		}
		return con;
	}
}