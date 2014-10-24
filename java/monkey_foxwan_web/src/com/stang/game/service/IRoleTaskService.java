package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleTaskDetail;

public interface IRoleTaskService extends IBaseService<RoleTaskDetail>{
	public boolean insertRoleTask(Map<String, Object> param);
	
	public List<RoleTaskDetail> findRoleTask(int roleId);
	
	public boolean updateRoleTaskTye(int roleid,int type);//设置三日还是每日在线
	
	public boolean updateRoleTaskTime(int roleid,long time,int taskid);//增加礼包倒计时时间
	
	public boolean updateRoleTasknumday(Map<String, Object> param);//零点更新dailynum=0,day+1
	
	public boolean updateRoleTaskDailynum(Map<String, Object> param);//增加礼包领取次数
	
	public boolean updateRoleTaskStatus(Map<String, Object> param);//礼包是否已领取
}
