package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IHostStatusDao;
import com.stang.game.dao.impl.HostStatusDaoImpl;
import com.stang.game.entity.detail.HostStatusDetail;
import com.stang.game.service.IHostStatusService;

public class HostStatusServiceImpl extends BaseServiceImpl<HostStatusDetail>
implements IHostStatusService{
public IHostStatusDao getBaseDao(){
	if(baseDao==null){
		baseDao=new HostStatusDaoImpl();
	}
	return (IHostStatusDao) baseDao;
}
	public List<HostStatusDetail> getHostStatus() {
		// TODO Auto-generated method stub
		return getBaseDao().getHostStatus();
	}
	public boolean updateHostStatus(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateHostStatus(param);
	}
	public boolean updatehd(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updatehd(param);
	}

}
