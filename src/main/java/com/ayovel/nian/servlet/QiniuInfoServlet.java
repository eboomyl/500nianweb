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

import com.ayovel.nian.biz.QiniuBiz;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class QiniuInfoServlet extends QiniuBaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2532687070715216893L;
	QiniuBiz qiniubiz =new QiniuBiz();
	
	@Override
	JSONObject uploadSouImages(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		qiniubiz.uploadSouImages();
		return null;
	}

	@Override
	void deleteSouImages(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}