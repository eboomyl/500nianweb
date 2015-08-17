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
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class UserBaseServlet extends JsonRestServlet {

	private  final long serialVersionUID = 3563931679909603943L;

	/**
	 * 物品查询，分类，详情等相关处理
	 */
	@Override
	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter(RestConstants.ACTION_PARAM);
		String userid=  request.getParameter(RestConstants.USER_ID);
		
		JSONObject json;
		if (action.equals(RestConstants.USER_LOGIN)) {
			json=userLogin(request, response);
			userid=(String) json.get("userid");
			response.sendRedirect("mainpage");//跳转到功能列表页面
			if(StringUtils.isNotEmpty(userid)){
				response.sendRedirect("mainpage");//跳转到功能列表页面
			}
		} else if (action.equals(RestConstants.USER_REG)) {
			json = getUserReg(request, response);
			userid=(String) json.get("userid");
			if(StringUtils.isNotEmpty(userid)){
				response.sendRedirect("mainpage");//跳转到功能列表页面
			}
			
		}else{//除了登陆注册外，若userid为空，则跳转到登陆页面
			if(StringUtils.isEmpty(userid)){
				response.sendRedirect("userlogin");//跳转到登陆页面
			}
		}
		
		if (action.equals(RestConstants.USER_HOME)) {
			json = getUserHome(request, response);
		} else if (action.equals(RestConstants.USER_INFO)) {
			json = getUserInfo(request, response);
		}  else {
			throw new XServletException(HttpServletResponse.SC_BAD_REQUEST,
					ErrorCode.E0303, RestConstants.ACTION_PARAM, action);
		}

		if (json != null) {
			sendJsonResponse(response, HttpServletResponse.SC_OK, json);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
		}
	}

	abstract JSONObject userLogin(HttpServletRequest request,
			HttpServletResponse response);

	abstract JSONObject getUserHome(HttpServletRequest request,
			HttpServletResponse response);

	abstract JSONObject getUserInfo(HttpServletRequest request,
			HttpServletResponse response);

	abstract JSONObject getUserReg(HttpServletRequest request,
			HttpServletResponse response);

}