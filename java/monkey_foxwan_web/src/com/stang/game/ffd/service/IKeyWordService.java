package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityKeyWordDetail;

public interface IKeyWordService extends IBaseService<EntityKeyWordDetail> {

	public void insertEntityKeyWordDetaill(EntityKeyWordDetail keyWord);

	public void updateEntityKeyWordDetail(EntityKeyWordDetail keyWord);

	public List<EntityKeyWordDetail> findEntityKeyWordDetailByParam(
			Map<String, Object> map);

	public void deleteEntityKeyWordDetaill(EntityKeyWordDetail keyWord);


}
