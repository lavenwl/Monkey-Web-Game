package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.MemberDetail;

/**
 * @author jianbo.feng 
 * @company 上海三唐信息科技有限公司
 * @description 会员信息逻辑处理接口
 */
public interface IMemberService extends IBaseService<MemberDetail> {

	/**
	 * @method findMembersByIds
	 * @param ids {List<Integer>} 
	 * @return {List<MemberDetail>}
	 * @description 根据序列号组查询会员信息
	 */
	public List<MemberDetail> findMembersByIds(List<Integer> ids);
	
	public int updateMemberById(Map<String,Object> param);
}
