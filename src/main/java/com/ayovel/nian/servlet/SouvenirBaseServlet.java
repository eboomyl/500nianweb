/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ayovel.nian.servlet;

import com.ayovel.nian.exception.ErrorCode;
import com.ayovel.nian.exception.XServletException;
import com.ayovel.nian.utils.RestConstants;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class SouvenirBaseServlet extends JsonRestServlet {

	private static final long serialVersionUID = -1224841358921313361L;

	/**
	 * 物品查询，分类，详情等相关处理
	 */
	@Override
	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter(RestConstants.ACTION_PARAM);

		JSONObject json = null;
		if (action.equals(RestConstants.SOU_INFO)) {
			json = getSouvenirInfo(request, response);
		} else if (action.equals(RestConstants.SOUVENIR_TYPE_ID)) {
			json = getSouvenirType(request, response);
		} else if (action.equals(RestConstants.SOU_SEARCH)) {
			json = getSouvenirSearch(request, response);
		} else if (action.equals(RestConstants.CREATE_SOUTYPE)) {
			creatSouTypes(request, response);
		} else if (action.equals(RestConstants.DELETE_SOU)) {
			deleteSou(request, response);
		} else if (action.equals(RestConstants.DELETE_SOUTYPE)) {
			deleteSoutype(request, response);
		} else if (action.equals(RestConstants.UPDATE_SOUTYPE)) {
			updateSoutype(request, response);
		} else if (action.equals(RestConstants.SOUCHARGE_TYPE)) {
			chargeSoutype(request, response);
		} else if (action.equals(RestConstants.UPDATE_SOUPRO)) {
			updateSouBaseInfo(request, response);
		} else if (action.equals(RestConstants.CREATE_RECORD)) {
			createSouRecord(request, response);
		} else if (action.equals(RestConstants.DELETE_RECORD)) {
			deleteSouRecord(request, response);
		} else if (action.equals(RestConstants.UPDATE_RECORD)) {
			updateSouRecord(request, response);
		} else {
			throw new XServletException(HttpServletResponse.SC_BAD_REQUEST,
					ErrorCode.E0303, RestConstants.ACTION_PARAM, action);
		}
		if (json != null) {
			sendJsonResponse(response, HttpServletResponse.SC_OK, json);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
		}
	}

	//更新用户评论
	abstract void updateSouRecord(HttpServletRequest request,
			HttpServletResponse response);

	// 删除用户评论
	abstract void deleteSouRecord(HttpServletRequest request,
			HttpServletResponse response);

	// 创建用户评论
	abstract void createSouRecord(HttpServletRequest request,
			HttpServletResponse response);

	// 更新物品表内的基础信息，长宽高重量等等
	abstract void updateSouBaseInfo(HttpServletRequest request,
			HttpServletResponse response);

	// 变更物品类别
	abstract void chargeSoutype(HttpServletRequest request,
			HttpServletResponse response);

	// 变更类别名称
	abstract void updateSoutype(HttpServletRequest request,
			HttpServletResponse response);

	// 删除类别
	abstract void deleteSoutype(HttpServletRequest request,
			HttpServletResponse response);

	// 删除物品
	abstract void deleteSou(HttpServletRequest request,
			HttpServletResponse response);

	// 通过物品分类编码获取物品列表
	abstract JSONObject getSouvenirListForType(HttpServletRequest request,
			HttpServletResponse response);

	// 创建用户物品分类列表
	abstract void creatSouTypes(HttpServletRequest request,
			HttpServletResponse response);

	// 获取物品信息，评论，时间轴，图片等信息
	abstract JSONObject getSouvenirInfo(HttpServletRequest request,
			HttpServletResponse response);

	// 获取用户物品分类列表
	abstract JSONObject getSouvenirType(HttpServletRequest request,
			HttpServletResponse response);

	// 物品搜索功能
	abstract JSONObject getSouvenirSearch(HttpServletRequest request,
			HttpServletResponse response);

}