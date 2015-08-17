package com.ayovel.nian.modle;

public class SouvenirDTO extends BaseDTO {
	public String id;
	public String name;
	public String souvenirtypeid;
	public String souvenirtypecode;//分类中的序号,由页面自动生成，不在后台存储
	public String userid;
	public String dynastycode;
	public String lengths;
	public String wides;
	public String highs;
	public String weights;
	public String flowstatus;
	public String timerecord;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDynastycode() {
		return dynastycode;
	}
	public void setDynastycode(String dynastycode) {
		this.dynastycode = dynastycode;
	}
	public String getLengths() {
		return lengths;
	}
	public void setLengths(String lengths) {
		this.lengths = lengths;
	}
	public String getWides() {
		return wides;
	}
	public void setWides(String wides) {
		this.wides = wides;
	}
	public String getHighs() {
		return highs;
	}
	public void setHighs(String highs) {
		this.highs = highs;
	}
	public String getWeights() {
		return weights;
	}
	public void setWeights(String weights) {
		this.weights = weights;
	}
	public String getSouvenirtypecode() {
		return souvenirtypecode;
	}
	public void setSouvenirtypecode(String souvenirtypecode) {
		this.souvenirtypecode = souvenirtypecode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTimerecord() {
		return timerecord;
	}
	public void setTimerecord(String timerecord) {
		this.timerecord = timerecord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSouvenirtypeid() {
		return souvenirtypeid;
	}
	public void setSouvenirtypeid(String souvenirtypeid) {
		this.souvenirtypeid = souvenirtypeid;
	}
	public String getFlowstatus() {
		return flowstatus;
	}
	public void setFlowstatus(String flowstatus) {
		this.flowstatus = flowstatus;
	}
	
	

}
