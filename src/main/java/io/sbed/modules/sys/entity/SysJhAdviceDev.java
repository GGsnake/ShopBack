package io.sbed.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author heguoliang
 * @Description: TODO(官方订单通知表)
 * @date 2019-01-08 12:08:36
 */
public class SysJhAdviceDev implements Serializable {
	
	//
	private Integer id;
	//标题
	private String titile;
	//内容
	private String content;
	//头像
	private String image;
	//图片URL
	private String contentImage;
	//创建时间
	private Date createtime;
	//修改时间
	private Date updatetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitile() {
		return titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContentImage() {
		return contentImage;
	}

	public void setContentImage(String contentImage) {
		this.contentImage = contentImage;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
}
