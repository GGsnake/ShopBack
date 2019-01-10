package io.sbed.modules.sys.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @author heguoliang
 * @Description: TODO(每日爆款)
 * @date 2019-01-04 20:47:50
 */
public class SysDaygoods implements Serializable {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getTitile() {
		return titile;
	}

	public void setTitile(Long titile) {
		this.titile = titile;
	}

	public Long getContent() {
		return content;
	}

	public void setContent(Long content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContent_Images() {
		return content_Images;
	}

	public void setContent_Images(String content_Images) {
		this.content_Images = content_Images;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	//
	private Integer id;
	//标题
	private Long titile;
	//内容
	private Long content;
	//头像
	private String image;
	//图片内容url数组
	private String content_Images;
	//删除状态
	private Integer status;
	//创建时间
	private Date createtime;



}
