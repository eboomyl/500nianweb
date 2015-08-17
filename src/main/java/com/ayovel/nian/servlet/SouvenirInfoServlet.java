package com.ayovel.nian.servlet;


import com.ayovel.nian.biz.UserSouvenirBiz;
import com.ayovel.nian.modle.RecordinfoDTO;
import com.ayovel.nian.modle.SouvenirDTO;
import com.ayovel.nian.modle.SouvenirtypeDTO;
import com.ayovel.nian.utils.RestConstants;
import com.ayovel.nian.utils.SysUtils;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 器物信息获取
 * 
 * @author yuanlin
 * 
 */
public class SouvenirInfoServlet extends SouvenirBaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -33878931743813753L;
	
	UserSouvenirBiz userSouvenirBiz = new UserSouvenirBiz();

	@Override
	protected JSONObject getSouvenirInfo(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取物品详细信息，用户评论，时间轴，图片列表等
		String souvenirid = request.getParameter(RestConstants.SOUVENIR_ID);
		return userSouvenirBiz.getSouvenirInfo(souvenirid);

	}

	@Override
	protected JSONObject getSouvenirType(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取用户分类信息
		String userid = request.getParameter(RestConstants.USER_ID);
		return userSouvenirBiz.getSouvenirType(userid);
	}

	@Override
	protected JSONObject getSouvenirSearch(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取物品分类，定位物品位置，不提供详细信息
		//搜索栏录入物品编号
		String souvenircode = request.getParameter(RestConstants.SOUVENIR_CODE);
		String userid = request.getParameter(RestConstants.USER_ID);
		Map<String,String> paramMap= new HashMap<String,String>();
		paramMap.put("souvenircode", souvenircode);
		paramMap.put("userid", userid);
		return userSouvenirBiz.getSouvenirSearch(paramMap);
	}

	@Override
	protected void creatSouTypes(HttpServletRequest request,
			HttpServletResponse response) {
		String userid = request.getParameter(RestConstants.USER_ID);
		String soutypename = request.getParameter(RestConstants.SOUVENIR_TYPE_NAME);
		SouvenirtypeDTO soutypedto = new SouvenirtypeDTO();
		soutypedto.setId(SysUtils.getsoutypeid());
		soutypedto.setUserid(userid);
		soutypedto.setTypename(soutypename);
		soutypedto.setTypecount("0");
		soutypedto.setTimerecord(SysUtils.getNowTimeStr());
		userSouvenirBiz.creatSouTypes(soutypedto);
	}

	@Override
	protected JSONObject getSouvenirListForType(HttpServletRequest request,
			HttpServletResponse response) {
		String souvenirtypeid =  request.getParameter(RestConstants.SOUVENIR_TYPE_ID);
		String userid = request.getParameter(RestConstants.USER_ID);
		Map<String,String> paramMap= new HashMap<String,String>();
		paramMap.put("souvenirtypeid", souvenirtypeid);
		paramMap.put("userid", userid);
		return userSouvenirBiz.getSouvenirListForType(paramMap);
	}

	@Override
	protected void deleteSou(HttpServletRequest request,
			HttpServletResponse response) {
		String souvenirid = request.getParameter(RestConstants.SOUVENIR_ID);
		userSouvenirBiz.deleteSou(souvenirid);
	}

	@Override
	protected void deleteSoutype(HttpServletRequest request, HttpServletResponse response) {
		String soutypeid = request.getParameter(RestConstants.SOUVENIR_TYPE_ID);
		userSouvenirBiz.deleteSoutype(soutypeid);
	}

	@Override
	protected void updateSoutype(HttpServletRequest request, HttpServletResponse response) {
		String soutypeid = request.getParameter(RestConstants.SOUVENIR_TYPE_ID);
		String soutypename = request.getParameter(RestConstants.SOUVENIR_TYPE_NAME);
		SouvenirtypeDTO soutypedto= new SouvenirtypeDTO();
		soutypedto.setId(soutypeid);
		soutypedto.setTypename(soutypename);
		userSouvenirBiz.updateSoutype(soutypedto);
		
	}

	@Override
	protected void chargeSoutype(HttpServletRequest request, HttpServletResponse response) {
		String soutypeid = request.getParameter(RestConstants.SOUVENIR_TYPE_ID);
		String souid = request.getParameter(RestConstants.SOUVENIR_ID);
		SouvenirDTO soudto = new SouvenirDTO();
		soudto.setId(souid);
		soudto.setSouvenirtypeid(soutypeid);
		SouvenirDTO oldsouinfo=userSouvenirBiz.querySouBaseInfoForID(soudto);
		if(!soutypeid.equals(oldsouinfo.getSouvenirtypeid())){
			userSouvenirBiz.chargeSoutype(soudto);
		}
	}

	@Override
	protected void updateSouBaseInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String souid = request.getParameter(RestConstants.SOUVENIR_ID);
		String lengths = request.getParameter(RestConstants.SOUVENIR_LENGTHS);
		String wides = request.getParameter(RestConstants.SOUVENIR_WIDES);
		String highs = request.getParameter(RestConstants.SOUVENIR_HIGHS);
		String weights = request.getParameter(RestConstants.SOUVENIR_WEIGTHS);
		String dynastycode = request.getParameter(RestConstants.SOUVENIR_DYNASTYCODE);
		SouvenirDTO soudto = new SouvenirDTO();
		soudto.setId(souid);
		soudto.setLengths(lengths);
		soudto.setWides(wides);
		soudto.setHighs(highs);
		soudto.setWeights(weights);
		soudto.setDynastycode(dynastycode);
		userSouvenirBiz.updateSouBaseInfo(soudto);
		
	}

	@Override
	protected void createSouRecord(HttpServletRequest request,
			HttpServletResponse response) {
		String souid = request.getParameter(RestConstants.SOUVENIR_ID);
		String recordcontent=  request.getParameter(RestConstants.RECORD_CONTENT);
		RecordinfoDTO recorddto = new RecordinfoDTO();
		recorddto.setId(SysUtils.getrecordid());
		recorddto.setSouvenirid(souid);
		recorddto.setTimerecord(SysUtils.getNowTimeStr());
		recorddto.setContent(recordcontent);
		userSouvenirBiz.createSouRecord(recorddto);
		
	}
	
	@Override
	protected void deleteSouRecord(HttpServletRequest request,
			HttpServletResponse response) {
		String recordid = request.getParameter(RestConstants.RECORD_ID);
		RecordinfoDTO recorddto = new RecordinfoDTO();
		recorddto.setId(recordid);
		userSouvenirBiz.deleteSouRecord(recorddto);
	}

	@Override
	void updateSouRecord(HttpServletRequest request,
			HttpServletResponse response) {
		String recordid = request.getParameter(RestConstants.RECORD_ID);
		String recordcontent=  request.getParameter(RestConstants.RECORD_CONTENT);
		RecordinfoDTO recorddto = new RecordinfoDTO();
		recorddto.setId(recordid);
		recorddto.setTimerecord(SysUtils.getNowTimeStr());
		recorddto.setContent(recordcontent);
		userSouvenirBiz.updateSouRecord(recorddto);
		
	}

}
