package com.stang.game.cache;

import com.stang.game.common.GameConstants;
import com.stang.game.entity.detail.*;

import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheRoleMilitary {
	//缓存类操作的缓存对象(key:id, value:RoleMilitaryDetail)
	private static Map<Integer, RoleMilitaryDetail> roleMilitaries = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache roleMilitaryQueue = null;
	public static QueueCache roleMilitaryQueue_in = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheRoleMilitary(){
		if(thread == null){
			thread = new ThreadCache("roleMilitary");
			thread.start();
		}
		if(roleMilitaries == null)
			roleMilitaries = GlobalDatat.cacheRoleMilitaryDetails;
		if(roleMilitaryQueue == null)
			roleMilitaryQueue = new QueueCache("roleMilitary");
		if(roleMilitaryQueue_in == null)
			roleMilitaryQueue_in = new QueueCache("roleMilitary_in");
	}
	//根据roleid得到getRoleMilitary
	public List<RoleMilitaryDetail> getRoleMilitary(int roleid){
		//System.out.println("CacheROleMilitary__________________________________getRoleMilitary:" + roleid);
		List<RoleMilitaryDetail> list = new ArrayList<RoleMilitaryDetail>();
		RoleMilitaryDetail roleMilitary = null;
		List<Integer> militaries = GlobalDatat.cacheForRoleMilitary.get(roleid);
		if(militaries != null){
			for(int i = 0; i < militaries.size(); i++){
				try{
					roleMilitary = (RoleMilitaryDetail)roleMilitaries.get(militaries.get(i)).clone();
				}catch(Exception e){
					e.printStackTrace();
				}
				list.add(roleMilitary);
			}
		}
		return list;
	}
	//根据id得到getRoleMilitaryById
		public List<RoleMilitaryDetail> getRoleMilitaryById(int id){
			//System.out.println("CacheROleMilitary__________________________________getRoleMilitary:" + roleid);
			List<RoleMilitaryDetail> list = new ArrayList<RoleMilitaryDetail>();
			RoleMilitaryDetail roleMilitary = GlobalDatat.cacheRoleMilitaryDetails.get(id);
			list.add(roleMilitary);
			return list;
		}
	/**根据military的自增id得到武将列表	 */
		public List<RoleMilitaryDetail> getRoleMilitaryByMilitaryId(int id) {
			//System.out.println("CacheROleMilitary__________________________________getRoleMilitary:" + roleid);
			List<RoleMilitaryDetail> list = new ArrayList<RoleMilitaryDetail>();
			RoleMilitaryDetail roleMilitary = GlobalDatat.cacheRoleMilitaryDetails.get(id);
			list.add(roleMilitary);
			RoleMilitaryDetail roleMilitary2 = GlobalDatat.cacheRoleMilitaryDetails2.get(id);
			if(roleMilitary2!=null){
				list.add(roleMilitary2);
			}
			return list;
		}
	//插入新数据
	public boolean insertRoleMilitary(Map<String, Object> param){
		boolean b = false;
		try{
			//System.out.println("CacheRoleMilitary______________________________________insertRoleMilitary:param:" + param.toString());
			Object id = param.get("id");
			Object roleId = param.get("roleId");
			Object militaryid = param.get("militaryid");
			Object name = param.get("name");
			Object level = param.get("level");
			Object type = param.get("type");
			Object types = param.get("types");
			Object exp = param.get("exp");
			Object time = param.get("time");
			Object xltype = param.get("xltype");
			Object wuqi = param.get("wuqi");
			Object huwan = param.get("huwan");
			Object shipin = param.get("shipin");
			Object touguan = param.get("touguan");
			Object yifu = param.get("yifu");
			Object xiezi = param.get("xiezi");
			
			Object challenge = param.get("challenge");
			Object fuben = param.get("fuben");
			Object bing = param.get("bing");
			Object bingstatus = param.get("bingstatus");
			RoleMilitaryDetail roleMilitary = new RoleMilitaryDetail();
			if(null != id)
				roleMilitary.setId(Integer.valueOf(String.valueOf(id)));
			if(null != roleId)
				roleMilitary.setRoleId(Integer.valueOf(String.valueOf(roleId)));
			if(null != militaryid)
				roleMilitary.setMilitaryid(Integer.valueOf(String.valueOf(militaryid)));
			if(null != name)
				roleMilitary.setName(String.valueOf(name));
			if(null != level)
				roleMilitary.setLevel(Integer.valueOf(String.valueOf(level)));
			if(null != type)
				roleMilitary.setType(Integer.valueOf(String.valueOf(type)));
			if(null != types)
				roleMilitary.setTypes(Integer.valueOf(String.valueOf(types)));
			if(null != exp)
				roleMilitary.setExp(Integer.valueOf(String.valueOf(exp)));
			if(null != time)
				roleMilitary.setTime(Integer.valueOf(String.valueOf(time)));
			if(null != xltype)
				roleMilitary.setXltype(Integer.valueOf(String.valueOf(xltype)));
			if(null != wuqi)
				roleMilitary.setWuqi(Integer.valueOf(String.valueOf(wuqi)));
			if(null != huwan)
				roleMilitary.setHuwan(Integer.valueOf(String.valueOf(huwan)));
			if(null != shipin)
				roleMilitary.setShipin(Integer.valueOf(String.valueOf(shipin)));
			if(null != touguan)
				roleMilitary.setTouguan(Integer.valueOf(String.valueOf(touguan)));
			if(null != yifu)
				roleMilitary.setYifu(Integer.valueOf(String.valueOf(yifu)));
			if(null != xiezi)
				roleMilitary.setXiezi(Integer.valueOf(String.valueOf(xiezi)));
	//		System.out.println("roleMilitary.flag" + roleMilitary.getFlag());
//			roleMilitary.setBing(1);
//			roleMilitary.setBingstatus("1");
			roleMilitary.setFlag(1);
			if(null != fuben)
				roleMilitary.setFuben(Integer.valueOf(String.valueOf(fuben)));
			if(null != bing){
				roleMilitary.setBing(Integer.valueOf(String.valueOf(bing)));
			}else{
				roleMilitary.setBing(1);
			}
				
			if(null != bingstatus){
				roleMilitary.setBingstatus(String.valueOf(bingstatus));
			}else{
				roleMilitary.setBingstatus("1");
			}
				//System.out.println("插入用户魔将：：：setBing"+roleMilitary.getBing()+":::setBingstatus:"+roleMilitary.getBingstatus());
			if(null != challenge)
				roleMilitary.setChallenge(Integer.valueOf(String.valueOf(challenge)));
			if(GlobalDatat.cacheForRoleMilitary.get(roleMilitary.getRoleId()) == null){
				List<Integer> militaries = new ArrayList<Integer>();
				militaries.add(roleMilitary.getId());
				GlobalDatat.cacheForRoleMilitary.put(roleMilitary.getRoleId(), militaries);
			}else{
				GlobalDatat.cacheForRoleMilitary.get(roleMilitary.getRoleId()).add(roleMilitary.getId());
			}
			//更新缓存
			//System.out.println("roleMilitary.getId():" + roleMilitary.getId());
			//System.out.println("roleMilitary.getRoleid:" + roleMilitary.getRoleId());
			roleMilitaries.put(roleMilitary.getId(), roleMilitary);
		//	System.out.println("ROleroleMilitary.getId()___________________" + roleMilitaries.get(roleMilitary.getId()).getName());
			
			//更新队列
			RoleMilitaryDetail r = new RoleMilitaryDetail();
			r = (RoleMilitaryDetail)roleMilitary.clone();
			r.setIsUpdate(2);
			roleMilitaryQueue_in.enqueue(r);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//更新数据
	public boolean updateRoleMilitary(Map<String, Object> param){
		//System.out.println("CacheRoleMilitary____________________________________updateROleMilitary:param:" + param.toString());
		boolean b = false;
		try{
			Object id = param.get("id");
			Object roleId = param.get("roleId");
			Object militaryid = param.get("militaryid");
			Object level = param.get("level");
			Object type = param.get("type");
			Object types = param.get("types");
			Object exp = param.get("exp");
			Object time = param.get("time");
			Object xltype = param.get("xltype");
			Object wuqi = param.get("wuqi");
			Object huwan = param.get("huwan");
			Object shipin = param.get("shipin");
			Object touguan = param.get("touguan");
			Object yifu = param.get("yifu");
			Object challenge = param.get("challenge");
			Object fuben = param.get("fuben");
			Object bing = param.get("bing");
			Object bingstatus = param.get("bingstatus");
			Object xiezi = param.get("xiezi");
			RoleMilitaryDetail roleMilitary = null;
			if(null != id){
				roleMilitary = roleMilitaries.get(Integer.valueOf(String.valueOf(id)));
			}else{
				int roleidd = 0;
				int militaryidd = 0;
				if(null != roleId)
					roleidd = Integer.valueOf(String.valueOf(roleId));
				if(null != militaryid)
					militaryidd = Integer.valueOf(String.valueOf(militaryid));
				if(roleidd != 0){
					List<Integer> militaries = GlobalDatat.cacheForRoleMilitary.get(roleidd);
					if(militaries != null){
						for(int i = 0; i < militaries.size(); i++){
							roleMilitary = roleMilitaries.get(militaries.get(i));
							if(roleMilitary.getRoleId() == (roleidd == 0 ? roleMilitary.getRoleId() : roleidd) &&
									roleMilitary.getMilitaryid() == (militaryidd == 0 ? roleMilitary.getMilitaryid() : militaryidd)){
								//GameConstants.log.warn("updateRoleMilitary 缓存更新用户魔将信息：");
								break;
							}
						}
					}
					
				}else{
					Iterator it = roleMilitaries.keySet().iterator();
					while(it.hasNext()){
						Integer i = Integer.valueOf(it.next().toString());
						roleMilitary = roleMilitaries.get(i);
						
						if(roleMilitary.getRoleId() == (roleidd == 0 ? roleMilitary.getRoleId() : roleidd) &&
								roleMilitary.getMilitaryid() == (militaryidd == 0 ? roleMilitary.getMilitaryid() : militaryidd)){

							break;
						}
					}
				}
			}
			if(null != fuben)
				roleMilitary.setFuben(Integer.valueOf(String.valueOf(fuben)));
			if(null != bing)
				roleMilitary.setBing(Integer.valueOf(String.valueOf(bing)));
			if(null != bingstatus)
				roleMilitary.setBingstatus(String.valueOf(bingstatus));
			if(null != challenge)
				roleMilitary.setChallenge(Integer.valueOf(String.valueOf(challenge)));
			if(null != level)
				roleMilitary.setLevel(Integer.valueOf(String.valueOf(level)));
			if(null != type)
				roleMilitary.setType(Integer.valueOf(String.valueOf(type)));
			if(null != types)
				roleMilitary.setTypes(Integer.valueOf(String.valueOf(types)));
			if(null != exp)
				roleMilitary.setExp(Integer.valueOf(String.valueOf(exp)));
			if(null != time)
				roleMilitary.setTime(Long.valueOf(String.valueOf(time)));
			if(null != xltype)
				roleMilitary.setXltype(Integer.valueOf(String.valueOf(xltype)));
			if(null != wuqi)
				roleMilitary.setWuqi(Integer.valueOf(String.valueOf(wuqi)));
			if(null != huwan)
				roleMilitary.setHuwan(Integer.valueOf(String.valueOf(huwan)));
			if(null != shipin)
				roleMilitary.setShipin(Integer.valueOf(String.valueOf(shipin)));
			if(null != touguan)
				roleMilitary.setTouguan(Integer.valueOf(String.valueOf(touguan)));
			if(null != yifu)
				roleMilitary.setYifu(Integer.valueOf(String.valueOf(yifu)));
			if(null != xiezi)
				roleMilitary.setXiezi(Integer.valueOf(String.valueOf(xiezi)));
			//更新缓存
			//roleMilitaries.remove(roleMilitary.getId());
			roleMilitaries.put(roleMilitary.getId(), roleMilitary);
			//更新队列
			roleMilitary.setIsUpdate(1);
			if(roleMilitaryQueue.indexMap.containsKey(roleMilitary.getId())){
				//System.out.println("CacheRoleMilitary避免了一次插入！");
			}else{
				roleMilitaryQueue.indexMap.put(roleMilitary.getId(), null);
				roleMilitaryQueue.enqueue(roleMilitary);
			}
			
			b = true;
		}catch(Exception e){
			System.out.println("CacheRoleMilitary报错");
//			e.printStackTrace();
		}
		return b;
	}
	
	//更新数据
		public boolean updateRoleMilitary(RoleMilitaryDetail detail){
			//System.out.println("CacheRoleMilitary____________________________________updateROleMilitary:param:" + param.toString());
			boolean b = false;
			try{
				RoleMilitaryDetail roleMilitary  = roleMilitaries.get(detail.getId());
				//更新缓存
				//roleMilitaries.remove(roleMilitary.getId());
				roleMilitaries.put(roleMilitary.getId(), roleMilitary);
				//更新队列
				roleMilitary.setIsUpdate(1);
				if(roleMilitaryQueue.indexMap.containsKey(roleMilitary.getId())){
					//System.out.println("CacheRoleMilitary避免了一次插入！");
				}else{
					roleMilitaryQueue.indexMap.put(roleMilitary.getId(), null);
					roleMilitaryQueue.enqueue(roleMilitary);
				}
				
				b = true;
			}catch(Exception e){
				e.printStackTrace();
			}
			return b;
		}
		
		//更新数据
				public boolean updateRoleMilitaryc(RoleMilitaryDetail detail){
					//System.out.println("CacheRoleMilitary____________________________________updateROleMilitary:param:" + param.toString());
					boolean b = false;
					try{
						RoleMilitaryDetail roleMilitary  = detail;
						//更新缓存
						//roleMilitaries.remove(roleMilitary.getId());
						roleMilitaries.put(roleMilitary.getId(), roleMilitary);
						//更新队列
						roleMilitary.setIsUpdate(1);
						if(roleMilitaryQueue.indexMap.containsKey(roleMilitary.getId())){
							//System.out.println("CacheRoleMilitary避免了一次插入！");
						}else{
							roleMilitaryQueue.indexMap.put(roleMilitary.getId(), null);
							roleMilitaryQueue.enqueue(roleMilitary);
						}
						
						b = true;
					}catch(Exception e){
						e.printStackTrace();
					}
					return b;
				}
	
	//根据id查询roleMilitarylevel
	public List<RoleMilitaryDetail> getRoleMilitarylevel(int id){
		//System.out.println("CacheRoleMilitary__________________________________getRoleMIlitary:id:" + id);
		List<RoleMilitaryDetail> list = new ArrayList<RoleMilitaryDetail>();
		if(null != roleMilitaries.get(id))
			list.add(roleMilitaries.get(id));
		return list;
	}
	//根据映射map的到数据
	public List<RoleMilitaryDetail> getRoleMilitaryByparam(Map<String, Object> param){
		//System.out.println("CacheROleMilitary_____________________________________getRoleMilitaryByparam():param:" + param.toString());
		List<RoleMilitaryDetail> list = new ArrayList<RoleMilitaryDetail>();
		Object id = param.get("id");
		Object roleId = param.get("roleId");
		Object militaryid = param.get("militaryid");
		Object fuben = param.get("fuben");
		if(null != id){
			list.add(roleMilitaries.get(Integer.valueOf(String.valueOf(id))));
		}else{
			int roleIdd = 0;
			int militaryidd = 0;
			int fubend = 0;
			if(null != roleId)
				roleIdd = Integer.valueOf(String.valueOf(roleId));
			if(null != militaryid)
				militaryidd = Integer.valueOf(String.valueOf(militaryid));
			if(null != fuben)
				fubend = Integer.valueOf(String.valueOf(fuben));
		//	System.out.println("roleIdd:" + roleIdd + " militaryid:" + militaryidd);
			RoleMilitaryDetail roleMilitary = new RoleMilitaryDetail();
			if(roleIdd != 0){
				List<Integer> militaries = GlobalDatat.cacheForRoleMilitary.get(roleIdd);
		//		System.out.println("militaries.size();" + militaries.size());
				if(militaries != null){
					for(int i = 0; i < militaries.size(); i++){
						roleMilitary = (RoleMilitaryDetail)roleMilitaries.get(militaries.get(i));
						//	System.out.println("roleMilita_________________ry:" + roleMilitary.getRoleId() + "   ||  " + roleMilitary.getMilitaryid());
						//	System.out.println("roleIdd:" + roleIdd + " militaryid:" + militaryidd);
							if(roleMilitary.getRoleId() == (roleIdd == 0 ? roleMilitary.getRoleId() : roleIdd) &&
									roleMilitary.getMilitaryid() == (militaryidd == 0 ? roleMilitary.getMilitaryid() : militaryidd) &&
									roleMilitary.getFuben() == (fubend == 0 ? roleMilitary.getFuben() : fubend)){
								//System.out.println("roleMilita_________________ry:" + roleMilitary.getRoleId() + "   ||  " + roleMilitary.getMilitaryid());
								list.add(roleMilitary);
								//break;
							}
					}
				}
				
			}else{
				Iterator it = roleMilitaries.keySet().iterator();
				while(it.hasNext()){
					Integer i = Integer.valueOf(it.next().toString());
					roleMilitary = (RoleMilitaryDetail)roleMilitaries.get(i);
				//	System.out.println("roleMilita_________________ry:" + roleMilitary.getRoleId() + "   ||  " + roleMilitary.getMilitaryid());
				//	System.out.println("roleIdd:" + roleIdd + " militaryid:" + militaryidd);
					if(roleMilitary.getRoleId() == (roleIdd == 0 ? roleMilitary.getRoleId() : roleIdd) &&
							roleMilitary.getMilitaryid() == (militaryidd == 0 ? roleMilitary.getMilitaryid() : militaryidd) &&
							roleMilitary.getFuben() == (fubend == 0 ? roleMilitary.getFuben() : fubend)){
						//System.out.println("roleMilita_________________ry:" + roleMilitary.getRoleId() + "   ||  " + roleMilitary.getMilitaryid());
						list.add(roleMilitary);
						//break;
					}
				}
			}
		}
		
		Collections.sort(list, new Comparator<RoleMilitaryDetail>(){
            public int compare(RoleMilitaryDetail arg0, RoleMilitaryDetail arg1) {
            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            	Long t1 = null;
            	Long t2 = null;
            	try{
            		t1 = Long.valueOf(arg0.getLevel());
	            	t2 = Long.valueOf(arg1.getLevel());
            	}catch(Exception e){
            		e.printStackTrace();
            	}
                return t1.compareTo(t2);
            }
		});
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!完美返回！" + list.size());
		return list;
	}
	//getRoleMilitaryBynotType
	public List<RoleMilitaryDetail> getRoleMilitaryBynotType(Map<String, Object> param){
		//System.out.println("CacheRoleMilitary________________________________getRoleMIlitary:param:" + param.toString());
		List<RoleMilitaryDetail> list = new ArrayList<RoleMilitaryDetail>();
		int roleid = Integer.valueOf(String.valueOf(param.get("roleId")));
		RoleMilitaryDetail roleMilitary = null;
		List<Integer> militaries = GlobalDatat.cacheForRoleMilitary.get(roleid);
		if(militaries != null){
			for(int i = 0; i < militaries.size(); i++){
				roleMilitary = roleMilitaries.get(militaries.get(i));
				if(roleMilitary.getRoleId() == roleid && roleMilitary.getXltype() > 0){
					list.add(roleMilitary);
				}
			}
		}
		
		return list;
	}
	//删除数据
	public boolean deleteRoleMilitary(Map<String, Object> param){
		//System.out.println("CacheRoleMilitary_______________________deleteRoleMilitary:param:" + param.toString());
		boolean b = false;
		try{
			Object id = param.get("id");
			Object roleid = param.get("roleId");
			RoleMilitaryDetail roleMilitary = new RoleMilitaryDetail();
			if(null != id){
				roleMilitary = (RoleMilitaryDetail)roleMilitaries.get(Integer.valueOf(String.valueOf(id))).clone();
			}else{
				System.out.println("CacheRoleMilitary.deleteRoleMilitary()方法欲删除玩家:" + roleid + "所有的数据！！");
			}
			//更新缓存
			//roleMilitaries.remove(roleMilitary.getId());
			roleMilitaries.get(roleMilitary.getId()).setFlag(0);
			//更新辅助数据结构
			List<Integer> militaries = GlobalDatat.cacheForRoleMilitary.get(roleMilitary.getRoleId());
			//System.out.println("cacheRoleMiltiary.size():" + militaries.size() + " CacheRoleMilitary:_____________RoleId:" + roleMilitary.getRoleId() + " MilitaryId:" + roleMilitary.getMilitaryid());
			if(militaries != null){
				for(int i = 0; i < militaries.size(); i++){
					if(militaries.get(i) == roleMilitary.getId())
						militaries.remove(i);
				}
			}
			
			//System.out.println("cacheRoleMiltiary.size():" + militaries.size() );
			//更新队列
			roleMilitary.setIsUpdate(3);
			roleMilitaryQueue.enqueue(roleMilitary);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//得到玩家相应等级的查数据
	public List<RoleMilitaryDetail> getRoleMilitaryByLevel(Map<String, Object> param){
		//System.out.println("CacheRoleMilitary________________________getRoleMiltikaryByLevel:param:" + param.toString());
		List<RoleMilitaryDetail> list = new ArrayList<RoleMilitaryDetail>();
		int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
		int level = Integer.valueOf(String.valueOf(param.get("level")));
		RoleMilitaryDetail roleMilitary = null;
		List<Integer> militaries = GlobalDatat.cacheForRoleMilitary.get(roleid);
		if(militaries != null){
			for(int i = 0; i < militaries.size(); i++){
				roleMilitary = roleMilitaries.get(militaries.get(i));
				if(roleMilitary.getRoleId() == roleid && roleMilitary.getLevel() >= level){
					list.add(roleMilitary);
				}
			}
		}
		
		return list;
	}
	public void insertRoleMilitary(RoleMilitaryDetail roleMilitaryDetail) {
		// TODO Auto-generated method stub

		boolean b = false;
		try{
			RoleMilitaryDetail roleMilitary = roleMilitaryDetail;
			//更新缓存
			//System.out.println("roleMilitary.getId():" + roleMilitary.getId());
			//System.out.println("roleMilitary.getRoleid:" + roleMilitary.getRoleId());
			roleMilitaries.put(roleMilitary.getId(), roleMilitary);
		//	System.out.println("ROleroleMilitary.getId()___________________" + roleMilitaries.get(roleMilitary.getId()).getName());
			
			//更新队列
			RoleMilitaryDetail r = new RoleMilitaryDetail();
			r = (RoleMilitaryDetail)roleMilitary.clone();
			r.setIsUpdate(2);
			roleMilitaryQueue_in.enqueue(r);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
}
