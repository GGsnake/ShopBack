package io.sbed.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author heguoliang
 * @Description: TODO()
 * @date 2019-03-07 09:37:51
 */
public class SysJhConfig implements Serializable {
	
	//
	private Long id;
	//
	private String configno;
	//
	private String configname;
	//
	private String configvalue;
	//
	private String remark;
	//
	private String editby;
	//
	private String edittime;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setConfigno(String configno) {
		this.configno = configno;
	}
	/**
	 * 获取：
	 */
	public String getConfigno() {
		return configno;
	}
	/**
	 * 设置：
	 */
	public void setConfigname(String configname) {
		this.configname = configname;
	}
	/**
	 * 获取：
	 */
	public String getConfigname() {
		return configname;
	}
	/**
	 * 设置：
	 */
	public void setConfigvalue(String configvalue) {
		this.configvalue = configvalue;
	}
	/**
	 * 获取：
	 */
	public String getConfigvalue() {
		return configvalue;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：
	 */
	public void setEditby(String editby) {
		this.editby = editby;
	}
	/**
	 * 获取：
	 */
	public String getEditby() {
		return editby;
	}
	/**
	 * 设置：
	 */
	public void setEdittime(String edittime) {
		this.edittime = edittime;
	}
	/**
	 * 获取：
	 */
	public String getEdittime() {
		return edittime;
	}

}
