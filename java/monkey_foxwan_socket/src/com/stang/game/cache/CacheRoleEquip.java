package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;

/**
 * 具体对象的缓存类
 * 
 * @author Laven Wang
 * 
 */
public class CacheRoleEquip {
	// 缓存类操作的缓存对象(key:id, value:RoleEquipDetail)
	private static Map<Integer, RoleEquipDetail> roleEquips = null;
	// 变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache roleEquipQueue = null;
	public static QueueCache roleEquipQueue_in = null;
	// 静态类同步数据库线程
	public static ThreadCache thread = null;

	// 静态初始化方法
	public CacheRoleEquip() {
		if (thread == null) {
			thread = new ThreadCache("roleEquip");
			thread.start();
		}
		if (roleEquips == null)
			roleEquips = GlobalDatat.cacheRoleEquipDetails;
		if (roleEquipQueue == null)
			roleEquipQueue = new QueueCache("roleEquip");
		if (roleEquipQueue_in == null)
			roleEquipQueue_in = new QueueCache("roleEquip_in");
	}

	// 删除玩家查装备
	public boolean deleteRoleEquip(Map<String, Object> param) {
		boolean b = false;
		try {
			Object id = param.get("id");
			// int id = Integer.valueOf(String.valueOf(param.get("id")));
			int id2 = 0;
			if (null != id) {
				id2 = Integer.valueOf(String.valueOf(param.get("id")));
			}

			int roleid = Integer.valueOf(String.valueOf(param.get("roleId")));
			List<Integer> equips = GlobalDatat.cacheForRoleEquip.get(roleid);
			if (id2 == 0) {// id为空
				if (null != equips) {
					RoleEquipDetail roleEquip2 = new RoleEquipDetail();
					for (int i = 0; i < equips.size(); i++) {
						RoleEquipDetail roleEquip = roleEquips.get(equips
								.get(i));
						roleEquip2 = (RoleEquipDetail) roleEquip.clone();

						// 更新缓存
						// roleEquips.remove(roleEquip2.getId());
						roleEquips.get(roleEquip2.getId()).setFlag(0);
						// 更新队列
						roleEquip2.setIsUpdate(3);
						roleEquipQueue.enqueue(roleEquip2);
						b = true;
					}
					equips.clear();
				}

			} else {
				RoleEquipDetail roleEquip = new RoleEquipDetail();
				roleEquip = (RoleEquipDetail) roleEquips.get(id2).clone();
				// 更新缓存
				// roleEquips.remove(id2);
				roleEquips.get(id2).setFlag(0);
				// 更新队列
				roleEquip.setIsUpdate(3);
				roleEquipQueue.enqueue(roleEquip);
				b = true;
				// System.out.println("2删除道具的用户id:::"+roleid+"id:::"+id2);
				for (int i = 0; i < equips.size(); i++) {
					if (equips.get(i) == roleEquip.getEquipId())
						equips.remove(roleEquip.getEquipId());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 查询roleEquip表
	public List<RoleEquipDetail> getRoleEquip(Map<String, Object> param) {
//		System.out.println("param:" + param.toString());
		int roleidd = 0;
		int typed = 0;
		int equipidd = 0;
		List<RoleEquipDetail> list = new ArrayList<RoleEquipDetail>();
		// System.out.println("list:" + list.size());
		try {
			Object id = param.get("id");
			Object roleid = param.get("roleId");
			Object type = param.get("type");
			Object user = param.get("user");
			Object equipId = param.get("equipId");

			if (null != id) {
				if (null != roleEquips.get(Integer.valueOf(String.valueOf(id))))
					list.add(roleEquips
							.get(Integer.valueOf(String.valueOf(id))));
			} else {
				// System.out.println("CacheRoleEquip.getRoleEquip()方法参数没有id!");
				if (null != roleid)
					roleidd = Integer.valueOf(String.valueOf(roleid));
				if (null != equipId)
					equipidd = Integer.valueOf(String.valueOf(equipId));
				if (null != type)
					typed = Integer.valueOf(String.valueOf(type));
				// System.out.println("roleidd:" + roleidd + " equipidd:" +
				// equipidd + " typed:" + typed);
				if (roleidd != 0) {
//					System.out.println("位置1");
					List<Integer> equips = GlobalDatat.cacheForRoleEquip
							.get(roleidd);
					if (null != equips) {
						for (int i = 0; i < equips.size(); i++) {
							RoleEquipDetail roleEquip = roleEquips.get(equips.get(i));
							if (roleEquip.getUser().equals(
									null != user ? user : roleEquip.getUser())
									&& roleEquip.getRoleId() == (roleidd == 0 ? roleEquip
											.getRoleId()
											: roleidd)
									&& roleEquip.getEquipId() == (equipidd == 0 ? roleEquip
											.getEquipId()
											: equipidd)
									&& roleEquip.getType() == (typed == 0 ? roleEquip
											.getType()
											: typed)
									&& roleEquip.getFlag() == 1) {
								list.add(roleEquip);
							}
						}
					}
				} else {
//					System.out.println("位置2");
					Iterator it = roleEquips.keySet().iterator();
					while (it.hasNext()) {
						Integer i = Integer.valueOf(it.next().toString());
						RoleEquipDetail roleEquip = roleEquips.get(i);
						if (roleEquip.getUser().equals(
								null != user ? user : roleEquip.getUser())
								&& roleEquip.getRoleId() == (roleidd == 0 ? roleEquip
										.getRoleId()
										: roleidd)
								&& roleEquip.getEquipId() == (equipidd == 0 ? roleEquip
										.getEquipId()
										: equipidd)
								&& roleEquip.getType() == (typed == 0 ? roleEquip
										.getType()
										: typed) && roleEquip.getFlag() == 1) {
							list.add(roleEquip);
						}
					}
				}
			}
//			/**
//			 * 过滤重复装备
//			 */
//			RoleEquipDetail roleEquip = null;
//			RoleEquipDetail roleEquip2 = null;
//			for (int i = 0; i < list.size(); i++) {
//				roleEquip = list.get(i);
//				for (int j = i; j < list.size() - 1; j++) {
//					roleEquip2 = list.get(j + 1);
//					if (roleEquip.getId()==roleEquip2.getId()) {
//						list.remove(roleEquip2);
//						break;
//					}
//				}
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("list:" + list.size());
		return list;
	}

	// 插入玩家装备
	public boolean insertRoleEquip(RoleEquipDetail model1) {
		boolean b = false;
		try {
			RoleEquipDetail model = new RoleEquipDetail();
			model = (RoleEquipDetail) model1.clone();
			if (GlobalDatat.cacheForRoleEquip.containsKey(model.getRoleId())) {
				GlobalDatat.cacheForRoleEquip.get(model.getRoleId()).add(
						model.getId());
			} else {
				List<Integer> mapForRoleEquips = new ArrayList<Integer>();
				mapForRoleEquips.add(model.getId());
				GlobalDatat.cacheForRoleEquip.put(model.getRoleId(),
						mapForRoleEquips);
			}
			// 更新缓存
			roleEquips.put(model.getId(), model);
			// 更新队列
			model.setIsUpdate(2);
			roleEquipQueue_in.enqueue(model);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 更新玩家装备
	public boolean updateRoleEquip(Map<String, Object> param) {
		boolean b = false;
		try {
			int id = Integer.valueOf(String.valueOf(param.get("id")));
			Object roleId = param.get("roleId");
			Object dengji = param.get("dengji");
			RoleEquipDetail roleEquip = roleEquips.get(id);
			if (null != roleId)
				roleEquip.setRoleId(Integer.valueOf(String.valueOf(roleId)));
			if (null != dengji)
				roleEquip.setDengji(Integer.valueOf(String.valueOf(dengji)));
			// update cache
			// roleEquips.remove(id);
			roleEquips.put(id, roleEquip);
			// update queue
			roleEquip.setIsUpdate(1);
			if (roleEquipQueue.indexMap.containsKey(roleEquip.getId())) {
				// System.out.println("CacheRoleItem避免了一次插入！");
			} else {
				roleEquipQueue.indexMap.put(roleEquip.getId(), null);
				roleEquipQueue.enqueue(roleEquip);
			}
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 更新玩家装备
	public boolean updateRoleEquips(RoleEquipDetail detail) {
		boolean b = false;
		try {
			RoleEquipDetail roleEquip = detail;
			roleEquips.put(detail.getId(), roleEquip);
			// update queue
			roleEquip.setIsUpdate(1);
			if (roleEquipQueue.indexMap.containsKey(roleEquip.getId())) {
				// System.out.println("CacheRoleItem避免了一次插入！");
			} else {
				roleEquipQueue.indexMap.put(roleEquip.getId(), null);
				roleEquipQueue.enqueue(roleEquip);
			}
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 根据id查询玩家装备
	public List<RoleEquipDetail> getRoleEquipById(int bid) {
		// System.out.println("CacheRoleEquip.getRoleEquipById():param.__________________________bid:"
		// + bid );
		List<RoleEquipDetail> list = new ArrayList<RoleEquipDetail>();
		if (null != roleEquips.get(bid))
			list.add(roleEquips.get(bid));
		// System.out.println();
		return list;
	}

	// 根据equipId得到玩家装备
	public List<RoleEquipDetail> getRoleEquipByEquipId(Map<String, Object> param) {
		// System.out.println("高消耗方法执行！！！CacheRoleEquip.getRoleEquipId()循环次数：" +
		// roleEquips.size());
		int roleidd = 0;
		int equipidd = 0;
		int typed = 0;
		List<RoleEquipDetail> list = new ArrayList<RoleEquipDetail>();
		Object roleid = param.get("roleid");
		Object equipId = param.get("equipId");
		Object type = param.get("type");
		if (null != roleid)
			roleidd = Integer.valueOf(String.valueOf(roleid));
		if (null != equipId)
			equipidd = Integer.valueOf(String.valueOf(equipId));
		if (null != type)
			typed = Integer.valueOf(String.valueOf(type));
		if (roleidd != 0) {
			List<Integer> equips = GlobalDatat.cacheForRoleEquip.get(roleidd);
			if (null != equips) {
				for (int i = 0; i < equips.size(); i++) {
					RoleEquipDetail roleEquip = roleEquips.get(equips.get(i));
					if (roleEquip.getRoleId() == (roleidd == 0 ? roleEquip
							.getRoleId() : roleidd)
							&& roleEquip.getEquipId() == (equipidd == 0 ? roleEquip
									.getEquipId()
									: equipidd)
							&& roleEquip.getType() == (typed == 0 ? roleEquip
									.getType() : typed)
							&& roleEquip.getFlag() == 1) {
						list.add(roleEquip);
					}
				}
			}

		} else {
			Iterator it = roleEquips.keySet().iterator();
			while (it.hasNext()) {
				Integer i = Integer.valueOf(it.next().toString());
				RoleEquipDetail roleEquip = roleEquips.get(i);
				if (roleEquip.getRoleId() == (roleidd == 0 ? roleEquip
						.getRoleId() : roleidd)
						&& roleEquip.getEquipId() == (equipidd == 0 ? roleEquip
								.getEquipId() : equipidd)
						&& roleEquip.getType() == (typed == 0 ? roleEquip
								.getType() : typed) && roleEquip.getFlag() == 1) {
					list.add(roleEquip);
				}
			}
		}
		return list;
	}

	// 根据id更新玩家装备数据
	public boolean updateRoleEquipById(Map<String, Object> param) {
		// System.out.println("CacheRoleEquip.updateEquipById():param:" +
		// param.toString());
		boolean b = false;
		try {
			int id = Integer.valueOf(String.valueOf(param.get("id")));
			Object dengji = param.get("dengji");
			Object attack = param.get("attack");
			Object hpMax = param.get("hpMax");
			Object rectlength = param.get("rectlength");
			Object speed = param.get("speed");
			Object user = param.get("user");
			Object starlevel = param.get("starlevel");
			Object levelexp = param.get("levelexp");
			RoleEquipDetail roleEquip = roleEquips.get(id);
			// System.out.println("CacheRoleEquip.updateById:attack:" +
			// roleEquip.getAttack());
			if (null != dengji)
				roleEquip.setDengji(roleEquip.getDengji()
						+ Integer.valueOf(String.valueOf(dengji)));
			if (null != attack)
				roleEquip.setAttack(roleEquip.getAttack()
						+ Double.valueOf(String.valueOf(attack)));
			if (null != hpMax)
				roleEquip.setHpMax(roleEquip.getHpMax()
						+ Double.valueOf(String.valueOf(hpMax)));
			if (null != rectlength)
				roleEquip.setRectlength(roleEquip.getRectlength()
						+ Double.valueOf(String.valueOf(rectlength)));
			if (null != speed)
				roleEquip.setSpeed(roleEquip.getSpeed()
						+ Double.valueOf(String.valueOf(speed)));
			if (null != user)
				roleEquip.setUser(String.valueOf(user));
			if (null != starlevel)
				roleEquip.setStarlevel(Integer.valueOf(String
						.valueOf(starlevel)));
			if (null != levelexp)
				roleEquip
						.setLevelexp(Integer.valueOf(String.valueOf(levelexp)));
			// System.out.println("CacheRoleEquip.updateById:attack:" +
			// roleEquip.getAttack());
			// 更新缓存
			// roleEquips.remove(id);
			roleEquips.put(id, roleEquip);
			// 更新队列
			roleEquip.setIsUpdate(1);
			if (roleEquipQueue.indexMap.containsKey(roleEquip.getId())) {
				// System.out.println("CacheRoleItem避免了一次插入！");
			} else {
				roleEquipQueue.indexMap.put(roleEquip.getId(), null);
				roleEquipQueue.enqueue(roleEquip);
			}
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 根据id减少玩家装备的属性subRoleEquipById
	public boolean subRoleEquipById(Map<String, Object> param) {
		boolean b = false;
		try {
			int id = Integer.valueOf(String.valueOf(param.get("id")));
			Object dengji = param.get("dengji");
			Object attack = param.get("attack");
			Object hpMax = param.get("hpMax");
			Object rectlength = param.get("rectlength");
			Object speed = param.get("speed");
			RoleEquipDetail roleEquip = roleEquips.get(id);
			if (null != dengji)
				roleEquip.setDengji(roleEquip.getDengji()
						- Integer.valueOf(String.valueOf(dengji)));
			if (null != attack)
				roleEquip.setAttack(roleEquip.getAttack()
						- Double.valueOf(String.valueOf(attack)));
			if (null != hpMax)
				roleEquip.setHpMax(roleEquip.getHpMax()
						- Double.valueOf(String.valueOf(hpMax)));
			if (null != rectlength)
				roleEquip.setRectlength(roleEquip.getRectlength()
						- Double.valueOf(String.valueOf(rectlength)));
			if (null != speed)
				roleEquip.setSpeed(roleEquip.getSpeed()
						- Double.valueOf(String.valueOf(speed)));
			// 更新缓存
			// roleEquips.remove(id);
			roleEquips.put(id, roleEquip);
			// 更新队列
			roleEquip.setIsUpdate(1);
			if (roleEquipQueue.indexMap.containsKey(roleEquip.getId())) {
				// System.out.println("CacheRoleItem避免了一次插入！");
			} else {
				roleEquipQueue.indexMap.put(roleEquip.getId(), null);
				roleEquipQueue.enqueue(roleEquip);
			}
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// 根据等级得到固定玩家的装备
	public List<RoleEquipDetail> getRoleEquipByDengji(Map<String, Object> param) {
		// System.out.println("高消耗方法执行！！！CacheRoleEquip.getRoleEquipId()循环次数：" +
		// roleEquips.size());
		List<RoleEquipDetail> list = new ArrayList<RoleEquipDetail>();
		int dengji = Integer.valueOf(String.valueOf(param.get("dengji")));
		int roleid = Integer.valueOf(String.valueOf(param.get("roleid")));
		List<Integer> equips = GlobalDatat.cacheForRoleEquip.get(roleid);
		if (null != equips) {
			for (int i = 0; i < equips.size(); i++) {
				RoleEquipDetail roleEquip = roleEquips.get(equips.get(i));
				if (roleEquip.getRoleId() == roleid
						&& roleEquip.getDengji() >= dengji
						&& roleEquip.getFlag() == 1) {
					list.add(roleEquip);
				}
			}
		}

		return list;
	}

	// getRoleEquipUser
	public List<RoleEquipDetail> getRoleEquipUser(Map<String, Object> param) {
		int roleidd = 0;
		int typed = 0;
		List<RoleEquipDetail> list = new ArrayList<RoleEquipDetail>();
		Object id = param.get("id");
		Object roleid = param.get("roleid");
		Object type = param.get("type");
		if (null != id) {
			if (null != roleEquips.get(Integer.valueOf(String.valueOf(id))))
				list.add(roleEquips.get(Integer.valueOf(String.valueOf(id))));
		} else {
//			System.out.println("CacheRoleEquip.getRoleEquip()方法参数没有id!");
			if (null != roleid)
				roleidd = Integer.valueOf(String.valueOf(roleid));
			if (null != type)
				typed = Integer.valueOf(String.valueOf(type));
			List<Integer> equips = GlobalDatat.cacheForRoleEquip.get(roleidd);
			if (null != equips) {
				for (int i = 0; i < equips.size(); i++) {
					RoleEquipDetail roleEquip = roleEquips.get(equips.get(i));
					if (roleEquip.getRoleId() == (roleidd == 0 ? roleEquip
							.getRoleId() : roleidd)
							&& roleEquip.getFlag() == 1
							&& roleEquip.getUser().equals("0")//这样的==确定没错???  代码有问题
							&& roleEquip.getType() == (typed == 0 ? roleEquip.getType() : typed)) {
						list.add(roleEquip);
					}
				}
			}

		}
		return list;
	}
	
}
