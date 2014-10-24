package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityKeyWordDetail;

public interface IKeyWordDao extends IEntityDao<EntityKeyWordDetail> {

	public void deleteEntityKeyWordDetaill(EntityKeyWordDetail keyWord);

	public List<EntityKeyWordDetail> findEntityKeyWordDetailByParam(
			Map<String, Object> map);

	public void insertEntityKeyWordDetaill(EntityKeyWordDetail keyWord);

	public void updateEntityKeyWordDetail(EntityKeyWordDetail keyWord);

}
