package com.stang.game.ffd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.stang.game.ffd.common.GameConstants;
import com.stang.game.ffd.common.StangUtil;
import com.stang.game.ffd.common.StringUtil;
import com.stang.game.ffd.dao.impl.GameMailAttachmentsDaoImpl;
import com.stang.game.ffd.entity.detail.GameMailAttachmentsDetail;
import com.stang.game.ffd.entity.detail.GameMailDetail;
import com.stang.game.ffd.service.IGameMailAttachmentsService;
import com.stang.game.ffd.service.IGameMailService;
import com.stang.game.ffd.service.IGamePlaneService;
import com.stang.game.ffd.service.IGameRoleService;
import com.stang.game.ffd.service.impl.GameAvatarServiceImpl;
import com.stang.game.ffd.service.impl.GameEquipServiceImpl;
import com.stang.game.ffd.service.impl.GameItemServiceImpl;
import com.stang.game.ffd.service.impl.GameMailAttachmentsServiceImpl;
import com.stang.game.ffd.service.impl.GameMailServiceImpl;
import com.stang.game.ffd.service.impl.GamePlaneServiceImpl;
import com.stang.game.ffd.service.impl.GameRoleServiceImpl;
import com.stang.game.ffd.service.impl.RoleAvatarServiceImpl;
import com.stang.game.ffd.service.impl.RoleEquipServiceImpl;
import com.stang.game.ffd.service.impl.RoleItemServiceImpl;
import com.stang.game.ffd.service.impl.RolePlaneServiceImpl;

public class CheckMailAction implements ServletRequestAware {
	private String uname1;
	private String uname2;
	private Date timeEnd;
	private Date timeBegin;
	private String title;
	private HttpServletRequest request;
	private HttpSession session;

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = ServletActionContext.getRequest().getSession();
	}

	public String getUname1() {
		return uname1;
	}

	public void setUname1(String uname1) {
		this.uname1 = uname1;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Date getTimeBegin() {
		return timeBegin;
	}

	public void setTimeBegin(Date timeBegin) {
		this.timeBegin = timeBegin;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUname2() {
		return uname2;
	}

	public void setUname2(String uname2) {
		this.uname2 = uname2;
	}

	public String checkMail() {
		IGameMailService gameMailService = new GameMailServiceImpl();
		IGameRoleService gameRoleService = new GameRoleServiceImpl();
		IGamePlaneService gamePlaneService = new GamePlaneServiceImpl();
		IGameMailAttachmentsService gameMailAttachments = new GameMailAttachmentsServiceImpl();
		Integer sendId = 0;
		Integer reciveId = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		// param.put("startTime", value);
		if (this.uname1 != null && !this.uname1.equals("")) {
			sendId = gameRoleService.getRoleIdByRoeName(
					StringUtil.uriEncode(this.uname1, GameConstants.FORMAT))
					.get(0);
			if (sendId > 0)
				param.put("sender", sendId);
		}
		if (this.uname2 != null && !this.uname2.equals("")) {
			reciveId = gameRoleService.getRoleIdByRoeName(
					StringUtil.uriEncode(this.uname2, GameConstants.FORMAT))
					.get(0);
			if (reciveId > 0) {
				param.put("receiver", reciveId);
				System.out.println(reciveId);
			}
		}
		if (this.timeBegin != null && !this.timeBegin.equals("")) {
			param.put("timeBegin", this.timeBegin);
		}
		if (this.timeEnd != null && !this.timeEnd.equals("")) {
			param.put("timeEnd", this.timeEnd);
		}
		if (this.title != null && !this.title.equals("")) {
			param.put("mailTitle", this.title);
		}
		IGameRoleService grs = new GameRoleServiceImpl();
		if (param.size() > 0) {
			List<GameMailDetail> mailList = gameMailService
					.findGameMailDetailByParam(param);
			List<Map<String,Object>> reMap = new ArrayList<Map<String,Object>>();
			if (mailList.size() > 0) {
				for (int i = 0; i < mailList.size(); i++) {
					Map<String, Object> mailMap = new HashMap<String, Object>();
					GameMailDetail gameMailDetail = mailList.get(i);
					
					mailMap.put("mailContent", gameMailDetail.getMailContent());
					mailMap.put("mailTitle", gameMailDetail.getMailTitle());
					mailMap.put("sendTime", gameMailDetail.getSendTime());
					mailMap.put("receiver", grs
							.getRoleNameByRoleId(gameMailDetail.getReceiver()));
					if(gameMailDetail.getSender() == 0) {
					 mailMap.put("sender", "GM");
					 } else {
					mailMap.put("sender", grs
							.getRoleNameByRoleId(gameMailDetail.getSender()));
					 }

					param.clear();
					param.put("mailId", gameMailDetail.getId());
					List<GameMailAttachmentsDetail> attachmentsList = gameMailAttachments
							.findGameMailAttachmentsDetailByParam(param);
					List<Map<String, Object>> attachmentsMaps = new ArrayList<Map<String, Object>>();
					int resId = 0;
					for (GameMailAttachmentsDetail gma : attachmentsList) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("num", gma.getAttResNum());
						param.clear();
						param.put("id", gma.getAttResId());
						switch (gma.getAttType()) {
						case 0:
							map.put("name", "金币");
							break;
						case 1:
							resId = new RolePlaneServiceImpl().findPlaneIdById(param);
							param.clear();
							param.put("id", resId);
							map.put("name", gamePlaneService
									.getPlaneNameById(param));
							break;
						case 2:
							resId = new RoleEquipServiceImpl().findEquipIdById(param);
							param.clear();
							param.put("id", resId);
							map.put("name", new GameEquipServiceImpl()
									.getEquipNameById(param));
							break;
						case 3:
							resId = new RoleItemServiceImpl().findItemIdById(param);
							param.clear();
							param.put("id", resId);
							map.put("name", new GameItemServiceImpl()
									.getItemNameById(param));
							break;
						case 4:
							resId = new RoleAvatarServiceImpl().findAvatarIdById(param);
							param.clear();
							param.put("id", resId);
							map.put("name", new GameAvatarServiceImpl()
									.getAvatarNameById(param));
						}
						attachmentsMaps.add(map);

					}
					mailMap.put("att", attachmentsMaps);
					reMap.add(mailMap);
				}
				request.setAttribute("reMap", reMap);
				return "succ";
			}
		}
		return "succ";
	}
}
