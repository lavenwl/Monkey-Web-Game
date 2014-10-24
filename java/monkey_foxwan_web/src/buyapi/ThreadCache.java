package buyapi;

import com.stang.game.entity.detail.*;
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.client.ClientManager;
import com.stang.game.util.*;
import com.stang.game.service.impl.BaseServiceImpl;
import com.stang.game.dao.*;
import com.stang.game.dao.IGamblingItemDao;
import com.stang.game.dao.impl.*;

import dbconn.DBConnectionManager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import net.sf.json.JSONArray;

public class ThreadCache extends Thread{
	private static PrintWriter log;
	public ThreadCache(){}
	public ThreadCache(String name){
		this.setName(name);
	}
	public void run(){
		String logFile = "ThreadCache.txt";
		try {
			log = new PrintWriter(new FileWriter(logFile, true), true);
		} catch (IOException e) {
			System.err.println("无法打开日志文件：" + logFile);
			log = new PrintWriter(System.err);
		}
		log("==============================================THREADCACHE DEBUG BEGAIN!=================================================================");
		String name = this.getName();
		boolean bo = false;
			//System.out.println("同步线程启动！" + this.getName());
			log("同步线程启动！" + this.getName());
			int time = 2000;
			int l = null == Send.buyBeanQueue? 0:Send.buyBeanQueue.size();
			for(int i = 0; i <= l; ){
				try{
					if(l > 0){
						//队列有内容
						BuyBean bb = (BuyBean)Send.buyBeanQueue.front();
						if(null != bb){
							String openid = bb.getOpenid();
							String payitem = bb.getPayitem();
							String billno = bb.getBillno();
							String zoneid = bb.getZoneid();
							String amt = bb.getAmt();
							String payamt_coins = bb.getPayamt_coins();
							String token = bb.getToken();//备用
							int serverid = bb.getServerid();
							log("Thread getBuyBean openid:" + openid + " payitem:"+payitem + "serverid:"+serverid + "ThreadQueue.size:" + Send.buyBeanQueue.size());

							
							
							String provide_errno = String.valueOf(0);
							ClientManager cm = ClientManager.getInstance();
							DBConnectionManager dbp = DBConnectionManager.getInstance();
							Connection co = dbp.getConnection("server" + zoneid);
							Connection coS = dbp.getConnection("server");
							PreparedStatement st = null;
							PreparedStatement stS = null;
							ResultSet rs = null;
							ResultSet rsS = null;
							try {
								for(int j = 0; j < 3; j++){
									//发送道具
									st = co.prepareStatement("select id from member where member_username=? and serverid=?");
									st.setString(1, openid);
									st.setString(2, zoneid);
									rs = st.executeQuery();
									int rid=0;
									while(rs.next()){
										rid = rs.getInt("id");//人物id
									}
									String[] strs = payitem.split("\\*");
									if(strs.length!=3){
										log("payitem参数异常strs.length:" + strs.length);
									}
									int itemid = Integer.parseInt(strs[0]);
								
									String[] c = strs[1].split("\\.");
									st = co.prepareStatement("select vip,buyitem from game_role where id = ?");
									st.setInt(1, rid);
									rs = st.executeQuery();
									int vip = 0;
									String buyitem = null;
									while(rs.next()){
										vip = rs.getInt("vip");
										buyitem=rs.getString("buyitem");
									}
									int coin = 0;
									if(vip<2){
										coin = Integer.parseInt(c[0]);
									}else{
										coin = (int)(Integer.parseInt(c[0])*0.8);
									} 
									int num = Integer.parseInt(strs[2]);
									coin = coin*num;
									//判断是否存在
									st = co.prepareStatement("select id from role_item where roleid=? and itemid=?");
									st.setInt(1, rid);
									st.setInt(2, itemid);
									rs = st.executeQuery();
									long f = 0;
									while(rs.next()){
										f = rs.getLong("id");
									}
									if(f!=0){//存在该道具
										PreparedStatement st1 = null;
										//插入vip经验
										if(itemid==119||itemid==120||itemid==121||itemid==122||itemid==123){
											 //增加元宝
											st = co.prepareStatement("select coin from game_item where id=?");
											st.setInt(1, itemid);
											rs = st.executeQuery();
											int coins = 0;
											while(rs.next()){
												coins=rs.getInt("coin");
											}
											coins = coins*num;
											//插入vip经验
											updateGameRoleCoinAndCoinspend(coins, coin, rid, cm.getClient(serverid));
										}else if(itemid!=92){
											//插入vip经验
											updateGameRoleCoinspend(coin, rid, cm.getClient(serverid));
										}
									}else{
										//道具不存在
										long value = System.currentTimeMillis();
										if(itemid>=10000){
										    //购买的是图腾
											HashMap<String, Object> papa = new HashMap<String, Object>();
											HashMap<String, Object> infoMap=new HashMap<String, Object>();
											papa.put("roleid", rid);
											papa.put("itemid", itemid);
											papa.put("num", num);
											papa.put("coin", coin);
											infoMap.put("_guid", 0);
											infoMap.put("_cachekey", "noCachekey");
											infoMap.put("_sig", "robot");
											infoMap.put("_serverId", 1);
											infoMap.put("_pid", 1);
											infoMap.put("_cmd", "sys.cacheRoletotem");
											infoMap.put("_params", papa);
											infoMap.put("_key1", "1");
											infoMap.put("_key2", "0000");
											infoMap.put("_key3", "12");
											infoMap.put("_key3tang", "12");
											cm.getClient(serverid).smcHander.sendData(infoMap);
											papa=null;
											infoMap=null;
											//return;
										}else{
											if(itemid==92){
												insertRoleItem(value, rid, itemid, num, 6, cm.getClient(serverid));
											}else if(itemid==119||itemid==120||itemid==121||itemid==122||itemid==123){
												//增加元宝
												st = co.prepareStatement("select coin from game_item where id=?");
												st.setInt(1, itemid);
												rs = st.executeQuery();
												int coins = 0;
												while(rs.next()){
													coins=rs.getInt("coin");
												}
												coins = coins*num;
												//插入vip经验
												updateGameRoleCoinAndCoinspend(coins, coin, rid, cm.getClient(serverid));
											}else{
//												insertRoleItem(value, rid, itemid, num, 5, cm.getClient(serverid)); 没遮蔽前会出现如果role_item里没有itemid，在用Q点购买的时候就会出现两个物品
												//插入vip经验
												updateGameRoleCoinspend(coin, rid, cm.getClient(serverid));
												//等级礼包，标记已购买
												if(itemid==160||itemid==161||itemid==162||itemid==163||itemid==164||itemid==165||itemid==166||itemid==167||itemid==168||itemid==169){
													st = co.prepareStatement("select level,bylevel from game_role where id=?");
													st.setInt(1, rid);
													rs = st.executeQuery();
													String bylevel ="0";
													int level=1;
													while(rs.next()){
														level = rs.getInt("level");
														bylevel=rs.getString("bylevel");
													}
													st = co.prepareStatement("select level,bylevel from game_role where id=?");
													st.setInt(1, itemid);
													rs = st.executeQuery();
													int itemlevel = 0;
													while(rs.next()){
														itemlevel = rs.getInt("itemlevel");
													}
													if(!bylevel.contains(itemlevel+"")){
														JSONArray ary = JSONArray.fromObject(bylevel);
														ary.add(itemlevel);
														bylevel = ary.toString();
														updateGameRoleBylevel(bylevel, rid, cm.getClient(serverid));
														ary=null;
													}
												}
											}
										}
										
									}
									try{
										if(itemid>=10000){
											//如果是图腾则不发送道具
											Thread.sleep(2000);
										}else{
											sendApi(payitem, rid, cm.getClient(serverid));
											Thread.sleep(2000);
										}
										
									}catch(Exception e){
										e.printStackTrace();
									}
									long b = System.currentTimeMillis();
									dbp.freeConnection("server" + zoneid, co);
									dbp.freeConnection("server", coS);
									//System.out.println("发送完毕，检查发送状态！");
									log("发送完毕，检查发送状态！");
									st = co.prepareStatement("select status from delivery where openid =? and zoneid =?");
									st.setString(1, openid);
									st.setString(2, zoneid);
									ResultSet rsN = st.executeQuery();
									int status = -1;
									while(rsN.next()){
										status = rsN.getInt("status");
										if(status != -1)
											break;
									}
									//System.out.println("status:" + status);
									log("是否发送成功（1：失败；0：成功）:" + status);
									if(status == 0)
										break;
								}
								if(rs != null)
									rs.close();
								if(st != null)
									st.close();
								if(co != null)
									co.close();
								if(rsS != null)
									rsS.close();
								if(stS != null)
									stS.close();
								if(coS != null)
									coS.close();
								Send.buyBeanQueue.dequeue();
							} catch (SQLException e) {
								e.printStackTrace();
								log("Exception in this loop: openid:" + openid + " payitem:"+payitem + "serverid:"+serverid + "ThreadQueue.size:" + Send.buyBeanQueue.size());
							}
						}else{
							log("buyBean == nullllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
						}
					}else{
						//队列为空，一秒钟一次的定时器检测SendQueue
						try{
							if(bo){
								bo = false;
								//System.out.println(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
								log(this.getName() + "队列内无内容：" + l + "进入休眠时间：" + time);
							}
							this.sleep(time);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						l = Send.buyBeanQueue.size();
						if(l != 0){
							bo = true;
							//System.out.println(this.getName() + "得到的队列长度：" + l);
							log(this.getName() + "得到的队列长度：" + l);
						}		
					}
				}catch(Exception e){
					e.printStackTrace();
					try {
						this.sleep(time);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				l = Send.buyBeanQueue.size();
			}
		
	}
void sendApi(String payitem,int id,Client client){
		
		HashMap<String, Object> papa = new HashMap<String, Object>();
		HashMap<String, Object> infoMap=new HashMap<String, Object>();
		papa.put("payitem", payitem);
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", "noCachekey");
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", id);
		infoMap.put("_cmd", "mil.buyItems");
		infoMap.put("_params", papa);
		infoMap.put("_key1", "1");
		infoMap.put("_key2", "0000");
		infoMap.put("_key3", "12");
		infoMap.put("_key3tang", "12");
		client.smcHander.sendData(infoMap);
		papa=null;
		infoMap=null;
	}
	

	void updateRoleItemNum(int num,int rid, int itemid,Client client){
		
		
		HashMap<String, Object> papa = new HashMap<String, Object>();
		HashMap<String, Object> infoMap=new HashMap<String, Object>();
		papa.put("rid", rid);
		papa.put("num", num);
		papa.put("itemid", itemid);
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", "noCachekey");
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", rid);
		infoMap.put("_cmd", "sys.insertRoleItem");
		infoMap.put("_params", papa);
		infoMap.put("_key1", "1");
		infoMap.put("_key2", "0000");
		infoMap.put("_key3", "12");
		infoMap.put("_key3tang", "12");
		client.smcHander.sendData(infoMap);
		papa=null;
		infoMap=null;
	}
	
	void updateGameRoleCoinAndCoinspend(int coin,int coinspend, int rid,Client client){
		
		HashMap<String, Object> papa = new HashMap<String, Object>();
		HashMap<String, Object> infoMap=new HashMap<String, Object>();
		papa.put("rid", rid);
		papa.put("coin", coin);
		papa.put("coinspend", coinspend);
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", "noCachekey");
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", rid);
		infoMap.put("_cmd", "sys.udpateGameRoleCoinAndCoinspend");
		infoMap.put("_params", papa);
		infoMap.put("_key1", "1");
		infoMap.put("_key2", "0000");
		infoMap.put("_key3", "12");
		infoMap.put("_key3tang", "12");
		client.smcHander.sendData(infoMap);
		papa=null;
		infoMap=null;
	}
	
	void updateGameRoleCoinspend(int coinspend, int rid,Client client){
		
		HashMap<String, Object> papa = new HashMap<String, Object>();
		HashMap<String, Object> infoMap=new HashMap<String, Object>();
		papa.put("rid", rid);
		papa.put("coinspend", coinspend);
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", "noCachekey");
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", rid);
		infoMap.put("_cmd", "sys.udpateGameRoleCoinAndCoinspend");
		infoMap.put("_params", papa);
		infoMap.put("_key1", "1");
		infoMap.put("_key2", "0000");
		infoMap.put("_key3", "12");
		infoMap.put("_key3tang", "12");
		client.smcHander.sendData(infoMap);
		papa=null;
		infoMap=null;
	}
	
	void insertRoleItem(long id, int rid, int itemid, int num, int type,Client client){
		
		HashMap<String, Object> papa = new HashMap<String, Object>();
		HashMap<String, Object> infoMap=new HashMap<String, Object>();
		papa.put("rid", rid);
		papa.put("id", id);
		papa.put("itemid", itemid);
		papa.put("num", num);
		papa.put("type", type);
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", "noCachekey");
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", rid);
		infoMap.put("_cmd", "sys.insertRoleItem");
		infoMap.put("_params", papa);
		infoMap.put("_key1", "1");
		infoMap.put("_key2", "0000");
		infoMap.put("_key3", "12");
		infoMap.put("_key3tang", "12");
		client.smcHander.sendData(infoMap);
		papa=null;
		infoMap=null;
	}
	
	void updateGameRoleBylevel(String bylevel, int rid,Client client){
		
		HashMap<String, Object> papa = new HashMap<String, Object>();
		HashMap<String, Object> infoMap=new HashMap<String, Object>();
		papa.put("rid", rid);
		papa.put("bylevel", bylevel);
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", "noCachekey");
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", rid);
		infoMap.put("_cmd", "sys.updateGameRoleBylevel");
		infoMap.put("_params", papa);
		infoMap.put("_key1", "1");
		infoMap.put("_key2", "0000");
		infoMap.put("_key3", "12");
		infoMap.put("_key3tang", "12");
		client.smcHander.sendData(infoMap);
		papa=null;
		infoMap=null;
	}
	public static void log(String msg) {
		log.println(new Date() + ":" + msg);
	}
}
