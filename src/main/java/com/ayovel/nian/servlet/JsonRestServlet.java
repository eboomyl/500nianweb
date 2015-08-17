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


import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class JsonRestServlet extends HttpServlet {
	/**
	 * 
	 */
	private  final long serialVersionUID = 4275393110510768731L;
	
	static final String JSON_UTF8 = "application/json; charset=\"UTF-8\"";
	
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
	protected void sendJsonResponse(HttpServletResponse response, int statusCode, JSONStreamAware json)
            throws IOException {
        if (statusCode == HttpServletResponse.SC_OK || statusCode == HttpServletResponse.SC_CREATED) {
            response.setStatus(statusCode);
        }
        else {
            response.sendError(statusCode);
        }
        response.setStatus(statusCode);
        response.setContentType(JSON_UTF8);
        json.writeJSONString(response.getWriter());
    }
	
}
