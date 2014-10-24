package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.MemberDetail;

public interface IMemberDao extends IEntityDao<MemberDetail> {

	public List<MemberDetail> findMembersByIds(List<Integer> ids);

	public int updateMemberById(Map<String, Object> param);
	
}
