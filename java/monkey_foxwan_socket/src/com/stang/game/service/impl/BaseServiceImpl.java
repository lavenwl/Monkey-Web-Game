package com.stang.game.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.stang.game.common.GameConstants;
import com.stang.game.common.PageList;
import com.stang.game.common.PageProperty;
import com.stang.game.common.Response;
import com.stang.game.dao.IEntityDao;
import com.stang.game.service.IBaseService;
import com.stang.game.util.PageUtil;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description 业务逻辑基本处理
 */
public class BaseServiceImpl<T> implements IBaseService<T> {

	protected final Log log = LogFactory.getLog(this.getClass());

	protected IEntityDao<T> baseDao = null;

	/**
	 * @method getBaseDao
	 * @return {IEntityDao<T>}
	 * @description 获得数据操作对象
	 */
	protected IEntityDao<T> getBaseDao() {
		return baseDao;
	}

	/**
	 * @method createResponse
	 * @param reCode
	 *            {String} 操作结果代码
	 * @return {Resopse}
	 * @description 查询出对象,同操作结果信息,封装入Response,返回到Controller
	 */
	public Response createResponse(String reCode) {
		Response response = new Response();
		String reMessage = null;
		int result = GameConstants.CODE_DEFAULT_RESULT;
		if (GameConstants.CODE_SUCCESS.equals(reCode)) {
			result = GameConstants.CODE_DAO_SUCCESS;
		}
		reMessage = "reCode:" + reCode;
		response.setReturnInt(result);
		response.setReturnCode(reCode);
		response.setReturnMessage(reMessage);
		return response;
	}

	/**
	 * @method createResponse
	 * @param reCode
	 *            {String} 操作结果代码
	 * @param object
	 *            {Object} 查询返回对象
	 * @return {Resopse}
	 * @description 查询出对象,同操作结果信息,封装入Response,返回到Controller
	 */
	public Response createResponse(String reCode, Object object) {
		Response response = createResponse(reCode);
		response.setReturnObject(object);
		return response;
	}

	/**
	 * @method createResponse
	 * @param reCode
	 *            {String} 操作结果代码
	 * @return {Resopse} int型数据
	 * @description 查询出对象,同操作结果信息,封装入Response,返回到Controller
	 */
	public Response createResponse(String reCode, int value) {
		Response response = createResponse(reCode);
		response.setReturnInt(value);
		return response;
	}

	/**
	 * @method getCount
	 * @param pp
	 *            {PageProperty} 封装分页条件信息的类对象，供数据库查询
	 * @return {Resopse}
	 * @description 获取记录总数
	 */
	public Response getCount(PageProperty pp) {
		String reCode = GameConstants.CODE_SUCCESS;
		int count = 0;
		try {
			count = getBaseDao().findCount(pp);
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			log.error("error: " + e.toString());
			reCode = GameConstants.CODE_UNKNOWN_ERROR;
		}
		return createResponse(reCode, count);
	}

	/**
	 * @method insert
	 * @param model
	 *            {T} 提供插入的数据，封装在实体类对象
	 * @return {Resopse}
	 * @description 插入记录
	 */
	public Response insert(T model) {
		String reCode = GameConstants.CODE_SUCCESS;
		try {
			getBaseDao().insert(model);
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			log.error("error: " + e.toString());
			reCode = GameConstants.CODE_UNKNOWN_ERROR;
		}
		return createResponse(reCode);
	}

	/**
	 * @method getModel
	 * @param param
	 *            {Map} 多条件供数据库查询
	 * @return {Resopse}
	 * @description 获取实体对象数据
	 */
	public Response getModel(Map param) {
		String reCode = GameConstants.CODE_SUCCESS;
		T reModel = null;
		try {
			reModel = getBaseDao().getModel(param);
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			log.error("error: " + e.toString());
			reCode = GameConstants.CODE_UNKNOWN_ERROR;
		}
		return createResponse(reCode, reModel);
	}

	/**
	 * @method getModel
	 * @param id
	 *            {Serializable} 记录唯一标识符
	 * @return {Resopse}
	 * @description 获取实体对象数据
	 */
	public Response getModel(Serializable id) {
		Map parm = new HashMap();
		parm.put("id", id);
		return getModel(parm);
	}

	/**
	 * @method update
	 * @param model
	 *            {T} 提供更新的数据，封装在实体类对象
	 * @return {Resopse}
	 * @description 更新数据
	 */
	public Response update(T model) {
		String reCode = GameConstants.CODE_SUCCESS;
		try {
			getBaseDao().update(model);
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			log.error("error: " + e.toString());
			reCode = GameConstants.CODE_UNKNOWN_ERROR;
		}
		return createResponse(reCode);
	}

	/**
	 * @method delete
	 * @param id
	 *            {Serializable} 记录唯一标识符
	 * @return {Resopse}
	 * @description 删除记录
	 */
	public Response delete(Serializable id) {
		String reCode = GameConstants.CODE_SUCCESS;
		try {
			getBaseDao().delete(id);
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			log.error("error: " + e.toString());
			reCode = GameConstants.CODE_UNKNOWN_ERROR;
		}
		return createResponse(reCode);
	}

	/**
	 * @method getPageList
	 * @param pp
	 *            {PageProperty} 封装分页条件信息的类对象，供数据库查询
	 * @return {Resopse}
	 * @description 获取对应记录列表
	 */
	public Response getPageList(PageProperty pp) {
		String reCode = GameConstants.CODE_SUCCESS;
		PageList<T> pageList = null;
		try {
			int count = getBaseDao().findCount(pp);
			if (count > 0) {
				int start = PageUtil.getStart(pp.getNpage(), count, pp
						.getNpagesize());
				int end = PageUtil.getEnd(pp.getNpage(), count, pp
						.getNpagesize());
				pp.putParamMap("start", start);
				pp.putParamMap("end", end);
				pageList = new PageList<T>(pp, count, baseDao.findPageList(pp));
			}

		} catch (NumberFormatException e) {
			GameConstants.log.warn("", e);
			reCode = GameConstants.CODE_PARAMETER_ERROR;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			reCode = GameConstants.CODE_UNKNOWN_ERROR;
		}
		return createResponse(reCode, pageList);
	}

	/**
	 * @method listModel
	 * @param param
	 *            {Map} 查询条件
	 * @return {Resopse}
	 * @description 根据条件查询实体信息
	 */
	public Response listModel(Map parm) {
		String reCode = GameConstants.CODE_SUCCESS;
		List<T> list = new ArrayList<T>();
		try {
			list = getBaseDao().list(parm);
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			log.error("error: " + e.toString());
			reCode = GameConstants.CODE_UNKNOWN_ERROR;
		}
		return createResponse(reCode, list);
	}

	/**
	 * @method deleteList
	 * @param ids
	 *            {String} 序列号组
	 * @return {Resopse}
	 * @description 批量删除
	 */
	public Response deleteList(String ids) {
		String reCode = GameConstants.CODE_SUCCESS;
		try {
			getBaseDao().deleteList(ids);
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			log.error("error: " + e.toString());
			reCode = GameConstants.CODE_UNKNOWN_ERROR;
		}
		return createResponse(reCode);
	}
}
