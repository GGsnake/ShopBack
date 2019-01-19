package io.sbed.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author heguoliang
 * @Description: TODO(京东pid)
 * @date 2019-01-16 10:11:39
 */
public class SysPidjd implements Serializable {
	
	//id
	private Integer id;
	//pid
	private Long pid;

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
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * 获取：pid
	 */
	public Long getPid() {
		return pid;
	}

}
