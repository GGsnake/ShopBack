package io.sbed.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author heguoliang
 * @Description: TODO(拼多多pid)
 * @date 2018-12-30 16:48:00
 */
public class SysPidpdd implements Serializable {
	
	//id
	private Integer id;
	//pid
	private String pid;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：pid
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：pid
	 */
	public String getPid() {
		return pid;
	}

}
