package com.ayovel.nian.servlet;

import com.ayovel.nian.biz.UserSouvenirBiz;
import com.ayovel.nian.modle.UserinfoDTO;
import com.ayovel.nian.utils.RestConstants;
import com.ayovel.nian.utils.SysUtils;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用户登录注册
 * @author yuanlin
 *
 */
public class UserInfoServlet extends UserBaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6712875066638804204L;
	private UserSouvenirBiz userSouvenirBiz = new UserSouvenirBiz();

	//用户首页，获取用户物品分类列表，和默认分类物品列表
	@Override
	protected JSONObject getUserHome(HttpServletRequest request,
			HttpServletResponse response) {
		UserinfoDTO userinfo= new UserinfoDTO();
		String userid=request.getParameter(RestConstants.USER_ID);
		String userphone=request.getParameter(RestConstants.USER_PHONE);
		userinfo.setId(userid);
		userinfo.setUserphone(userphone);
		return userSouvenirBiz.getUserHomeInfo(userinfo);
	}

	//获取用户信息
	@Override
	protected JSONObject getUserInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String userid=request.getParameter(RestConstants.USER_ID);
		return userSouvenirBiz.getUserInfo(userid);
	}

	//用户注册
	@SuppressWarnings("unused")
	@Override
	protected JSONObject getUserReg(HttpServletRequest request,
			HttpServletResponse response) {
		String useremail=request.getParameter(RestConstants.USER_EMAIL);
		String userphone=request.getParameter(RestConstants.USER_PHONE);
		String userequ1=request.getParameter(RestConstants.USER_EQU1);
		String userequ2=request.getParameter(RestConstants.USER_EQU2);
		String usercard=request.getParameter(RestConstants.USER_CARD);
		String userpwd=request.getParameter(RestConstants.USER_PWD);
		String weixin=request.getParameter(RestConstants.USER_WX);
		UserinfoDTO userinfo = new UserinfoDTO(); 
		userinfo.setId(SysUtils.getuserid());
		userinfo.setUserphone(userphone);
		userinfo.setUserequ1(userequ1);
		userinfo.setUserequ2(userequ2);
		userinfo.setUsercard(usercard);
		userinfo.setUsername(userphone);
		userinfo.setUserpwd(userpwd);
		userinfo.setUseremail(useremail);
		userinfo.setWeixin(weixin);
		return userSouvenirBiz.getUserReg(userinfo);
	}

	@Override
	protected JSONObject userLogin(HttpServletRequest request,
			HttpServletResponse response) {
		return null;
	}

	

}
