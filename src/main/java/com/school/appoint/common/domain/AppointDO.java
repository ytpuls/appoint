package com.school.appoint.common.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author yangtao
 * @email 541502337@qq.com
 * @date 2020-03-20 16:42:48
 */
public class AppointDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer userId;
	//1-已完成2-已预约3-已过期
	private Integer doctorId;
	//
	private String status;
	//预约时间
	private String appointtime;
	//预约号码
	private String number;
	//1-已修改0-未修改
	private String ischange;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：1-已完成2-已预约3-已过期
	 */
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	/**
	 * 获取：1-已完成2-已预约3-已过期
	 */
	public Integer getDoctorId() {
		return doctorId;
	}
	/**
	 * 设置：
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：预约时间
	 */
	public void setAppointtime(String appointtime) {
		this.appointtime = appointtime;
	}
	/**
	 * 获取：预约时间
	 */
	public String getAppointtime() {
		return appointtime;
	}
	/**
	 * 设置：预约号码
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取：预约号码
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * 设置：1-已修改0-未修改
	 */
	public void setIschange(String ischange) {
		this.ischange = ischange;
	}
	/**
	 * 获取：1-已修改0-未修改
	 */
	public String getIschange() {
		return ischange;
	}
}
