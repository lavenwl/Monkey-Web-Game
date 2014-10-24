package com.stang.game.ffd.dao.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.stang.game.ffd.dao.IOrderInfoDao;
import com.stang.game.ffd.entity.detail.EntityOrderInfoDetail;

public class OrderInfoDaoImpl extends EntityDao<EntityOrderInfoDetail> implements IOrderInfoDao {

	public List<EntityOrderInfoDetail> getAllInfoOrderInfo(Map<String, Object> parm) {
		// TODO Auto-generated method stub
		List<EntityOrderInfoDetail> leoid=new ArrayList<EntityOrderInfoDetail>();
		try {									
			leoid=this.sqlMapperFlight.queryForList("findOrderInfoNewGuk",parm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leoid;
	}
	
	public List<EntityOrderInfoDetail> getAllInfoOrderInfo() {
		List<EntityOrderInfoDetail> leoid=new ArrayList<EntityOrderInfoDetail>();
		try {									
			leoid=this.sqlMapperFlight.queryForList("findOrderInfoNewGuk");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leoid;
	}
	
}
