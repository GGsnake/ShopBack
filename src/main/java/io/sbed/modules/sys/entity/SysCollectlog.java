package io.sbed.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author heguoliang
 * @Description: TODO(收集)
 * @date 2019-03-11 18:42:43
 */
public class SysCollectlog implements Serializable {
	
	//
	private Integer id;
	//采集数
	private Integer sum;
	//结束时间
	private Date createtime;

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
	 * 设置：采集数
	 */
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	/**
	 * 获取：采集数
	 */
	public Integer getSum() {
		return sum;
	}
	/**
	 * 设置：结束时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getCreatetime() {
		return createtime;
	}

}
