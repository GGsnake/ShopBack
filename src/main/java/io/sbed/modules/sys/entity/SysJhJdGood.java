package io.sbed.modules.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author heguoliang
 * @Description: TODO(京东采集表)
 * @date 2019-03-09 13:54:37
 */
public class SysJhJdGood implements Serializable {
	
	//
	private Integer id;
	//商品图片
	private String picturl;
	//店铺名
	private String shoptitle;
	//url
	private String jdurl;
	//标题
	private String title;
	//佣金比例
	private BigDecimal commissionrate;
	//优惠卷金额
	private Integer coupon;
	//推客的预估佣金额
	private BigDecimal zkfinalprice;
	//销量
	private Integer volume;
	//商品id
	private Long numiid;
	//删除状态
	private Integer status;
	//类目属性
	private Integer opt;
	//优惠卷权重
	private Integer orderCoupon;
	//佣金权重
	private Integer orderCommiss;
	//销量权重
	private Integer orderVolume;
	//创建时间
	private Date createtime;
	//
	private Integer istamll;
	//
	private BigDecimal commission;
	//cid
	private Integer cid;

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
	 * 设置：商品图片
	 */
	public void setPicturl(String picturl) {
		this.picturl = picturl;
	}
	/**
	 * 获取：商品图片
	 */
	public String getPicturl() {
		return picturl;
	}
	/**
	 * 设置：店铺名
	 */
	public void setShoptitle(String shoptitle) {
		this.shoptitle = shoptitle;
	}
	/**
	 * 获取：店铺名
	 */
	public String getShoptitle() {
		return shoptitle;
	}
	/**
	 * 设置：url
	 */
	public void setJdurl(String jdurl) {
		this.jdurl = jdurl;
	}
	/**
	 * 获取：url
	 */
	public String getJdurl() {
		return jdurl;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：佣金比例
	 */
	public void setCommissionrate(BigDecimal commissionrate) {
		this.commissionrate = commissionrate;
	}
	/**
	 * 获取：佣金比例
	 */
	public BigDecimal getCommissionrate() {
		return commissionrate;
	}
	/**
	 * 设置：优惠卷金额
	 */
	public void setCoupon(Integer coupon) {
		this.coupon = coupon;
	}
	/**
	 * 获取：优惠卷金额
	 */
	public Integer getCoupon() {
		return coupon;
	}
	/**
	 * 设置：推客的预估佣金额
	 */
	public void setZkfinalprice(BigDecimal zkfinalprice) {
		this.zkfinalprice = zkfinalprice;
	}
	/**
	 * 获取：推客的预估佣金额
	 */
	public BigDecimal getZkfinalprice() {
		return zkfinalprice;
	}
	/**
	 * 设置：销量
	 */
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	/**
	 * 获取：销量
	 */
	public Integer getVolume() {
		return volume;
	}
	/**
	 * 设置：商品id
	 */
	public void setNumiid(Long numiid) {
		this.numiid = numiid;
	}
	/**
	 * 获取：商品id
	 */
	public Long getNumiid() {
		return numiid;
	}
	/**
	 * 设置：删除状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：删除状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：类目属性
	 */
	public void setOpt(Integer opt) {
		this.opt = opt;
	}
	/**
	 * 获取：类目属性
	 */
	public Integer getOpt() {
		return opt;
	}
	/**
	 * 设置：优惠卷权重
	 */
	public void setOrderCoupon(Integer orderCoupon) {
		this.orderCoupon = orderCoupon;
	}
	/**
	 * 获取：优惠卷权重
	 */
	public Integer getOrderCoupon() {
		return orderCoupon;
	}
	/**
	 * 设置：佣金权重
	 */
	public void setOrderCommiss(Integer orderCommiss) {
		this.orderCommiss = orderCommiss;
	}
	/**
	 * 获取：佣金权重
	 */
	public Integer getOrderCommiss() {
		return orderCommiss;
	}
	/**
	 * 设置：销量权重
	 */
	public void setOrderVolume(Integer orderVolume) {
		this.orderVolume = orderVolume;
	}
	/**
	 * 获取：销量权重
	 */
	public Integer getOrderVolume() {
		return orderVolume;
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
	/**
	 * 设置：
	 */
	public void setIstamll(Integer istamll) {
		this.istamll = istamll;
	}
	/**
	 * 获取：
	 */
	public Integer getIstamll() {
		return istamll;
	}
	/**
	 * 设置：
	 */
	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getCommission() {
		return commission;
	}
	/**
	 * 设置：cid
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	/**
	 * 获取：cid
	 */
	public Integer getCid() {
		return cid;
	}

}
