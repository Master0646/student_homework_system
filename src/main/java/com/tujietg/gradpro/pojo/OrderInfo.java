package com.tujietg.gradpro.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 作业批次实体
 * 
 * Created by tujietg on Apr 15, 2019.
 */
public class OrderInfo implements Serializable {
	/**
	 * 作业批次ID
	 */
	private int oid;

	/**
	 * 老师id
	 */
	private String uid;

	/**
	 * 科目名
	 */
	private String oname;
	/**
	 * 作业名
	 */
	private String osubject;
	/**
	 * 是否允许上传
	 */
	private Boolean ostate;

	/**
	 * 作业内容
	 */
	private String describtion;

	/**
	 * 作业解答
	 */
	private String answer;
	/**
	 * 修改时间
	 */
	private Date otime;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Boolean getOstate() {
		return ostate;
	}

	public void setOstate(Boolean ostate) {
		this.ostate = ostate;
	}

	public Date getOtime() {
		return otime;
	}

	public void setOtime(Date otime) {
		this.otime = otime;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getOsubject() {
		return osubject;
	}

	public void setOsubject(String osubject) {
		this.osubject = osubject;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

}
