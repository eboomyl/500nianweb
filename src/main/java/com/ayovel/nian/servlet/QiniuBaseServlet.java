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

public abstract class QiniuBaseServlet extends JsonRestServlet {

	private static final long serialVersionUID = -1224841358921313361L;

	/**
	 * 七牛相关处理，物品图片上传下载等相关接口和sdk
	 */
	@SuppressWarnings("unused")
	@Override
	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter(RestConstants.ACTION_PARAM);

		JSONObject json = null;
		if (action.equals(RestConstants.CREATE_IMAGE)) {
			uploadSouImages(request,response);
		}else if(action.equals(RestConstants.DELETE_IMAGES)){
			deleteSouImages(request,response);
		}
		else {
			throw new XServletException(HttpServletResponse.SC_BAD_REQUEST,
					ErrorCode.E0303, RestConstants.ACTION_PARAM, action);
		}

		if (json != null) {
			sendJsonResponse(response, HttpServletResponse.SC_OK, json);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
		}
	}

	//删除图片
	abstract void deleteSouImages(HttpServletRequest request,
			HttpServletResponse response);

	// 图片上传
	abstract JSONObject uploadSouImages(HttpServletRequest request,
			HttpServletResponse response);

}