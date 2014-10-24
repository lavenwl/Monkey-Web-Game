package dbconn;

import java.sql.Connection;

public class Test {
	
	public static void main(String[] args) {
		try{
			DBConnectionManager dbp = DBConnectionManager.getInstance();
			Connection co = dbp.getConnection("server");
			System.out.println("Loading:serverId:" + " Connection:co:" + co);
			co.close();
			Connection co2 = dbp.getConnection("server" + 1);
			System.out.println("Loading:serverId:" + 1 + " Connection:co:" + co2);
			co2.close();
			Connection co3 = dbp.getConnection("server" + 2);
			System.out.println("Loading:serverId:" + 2 + " Connection:co:" + co3);
			co3.close();
			Connection co4 = dbp.getConnection("server" + 3);
			System.out.println("Loading:serverId:" + 3 + " Connection:co:" + co4);
			co4.close();
			Connection co5 = dbp.getConnection("server" + 4);
			System.out.println("Loading:serverId:" + 4 + " Connection:co:" + co5);
			co5.close();
		}catch(Exception e){
			
		}
		
	}
}
