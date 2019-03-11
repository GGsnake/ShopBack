package io.sbed.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author heguoliang
 * @Description: TODO(付款记录)
 * @date 2019-03-04 20:36:08
 */
public class SysJhPayLog implements Serializable {
	
	//
	private Integer id;
	//用户ID
	private Integer userid;
	//平台订单号
	private String ordersn;
	//审核状态
	private Integer accept;
	//创建时间
	private Date createtime;

	//创建时间
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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
	 * 设置：用户ID
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * 设置：平台订单号
	 */
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	/**
	 * 获取：平台订单号
	 */
	public String getOrdersn() {
		return ordersn;
	}
	/**
	 * 设置：审核状态
	 */
	public void setAccept(Integer accept) {
		this.accept = accept;
	}
	/**
	 * 获取：审核状态
	 */
	public Integer getAccept() {
		return accept;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}

}
