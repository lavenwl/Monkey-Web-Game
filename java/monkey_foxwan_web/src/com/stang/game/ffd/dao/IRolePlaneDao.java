package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.RolePlaneDetail;


public interface IRolePlaneDao extends IEntityDao<RolePlaneDetail> {

	public List<RolePlaneDetail> findRolePlanesByRoleId(Integer roleId);
	
	/**
	 * @method findRolePlanesByRoleIds
	 * @param roleIds {List<Integer>} 角色序列号组
	 * @return {List<RolePlaneDetail>} 
	 * @description 根据角色序列号组查询该角色当前使用的飞机
	 */
	public List<RolePlaneDetail> findRolePlanesByRoleIds(List<Integer> roleIds);
	
	/**
	 * @method batchDeleteRoleItems 
	 * @param ids {List<Integer>}
	 * @return {int}
	 * @description 批量删除角色-飞机关系信息
	 */
	public int batchDeleteRolePlanes(List<Integer> ids);
	
	public List<RolePlaneDetail> findUsingRolePlanesByRoleId(Integer roleId);
	
	/**
	 * @method findRolePlaneByRoleAndPlaneId 
	 * @param roleId {Integer}
	 * @param planeId {Integer}
	 * @return {RolePlaneDetail}
	 * @description 根据玩家序号和飞机模型序号查询玩家-飞机关系信息
	 */
	public RolePlaneDetail findRolePlaneByRoleAndPlaneId(Integer roleId,Integer planeId);
	
	/**
	 * 
	 * @param param
	 * @return List<RolePlaneDetail>
	 * @description 根据参数得到信息列表
	 */
	public List<RolePlaneDetail> getRolePlanes(Map<String, Object> param);
	
	/**
	 * 
	 * @param rpDetail
	 * @return
	 * @description 插入一条数据
	 */
	public boolean insertRolePlane(RolePlaneDetail rpDetail);
	
	/**
	 * 
	 * @param param
	 * @return
	 * @description 删除一条数据
	 */
	public int deleteRolePlane(Map<String, Object> param);
	
	/**
	 * 
	 * @param id
	 * @return
	 * @description 更新一条数据
	 */
	public int updateRolePlaneById(RolePlaneDetail rp);
	
	public int updateRolePlaneByRoleId(RolePlaneDetail rp);
	
	public int updateRolePlaneDetailByRoleIdAndPlaneId(Map<String, Object> param);
	/**
	 * 
	 * @param param
	 * @return
	 * @description 排行榜用
	 */
	public List<RolePlaneDetail> topRolePlanes(Map<String, Object> param);

	public int updateRolePlaneByPackageId(Map<String, Object> param);

	public boolean insertRolePlanes(List<RolePlaneDetail> planeList);

	public int findPlaneIdById(Map<String, Object> param);	
}
