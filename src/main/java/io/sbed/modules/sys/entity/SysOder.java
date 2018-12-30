package io.sbed.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author heguoliang
 * @Description: TODO(拼多多订单表)
 * @date 2018-12-30 17:05:00
 */
public class SysOder implements Serializable {
	
	//用户id
	private Long id;
	//订单号
	private String orderSn;
	//商品id
	private Long goodsId;
	//商品名
	private String goodsName;
	//商品图片url
	private String goodsThumbnailUrl;
	//购买商品的数量
	private Integer goodsQuantity;
	//订单中sku的单件价格，单位为分
	private Integer goodsPrice;
	//实际支付金额，单位为分
	private Integer orderAmount;
	//推广位ID
	private String pId;
	//佣金比例，千分比
	private Long promotionRate;
	//佣金金额，单位为分
	private Long promotionAmount;
	//订单状态： -1 未支付;0-已支付；1-已成团；2-确认收货；3-审核成功；4-审核失败（不可提现）；5-已经结算；8-非多多进宝商品（无佣金订单）
	private Integer orderStatus;
	//订单状态描述
	private String orderStatusDesc;
	//订单生成时间，UNIX时间戳
	private Long orderCreateTime;
	//支付时间
	private Long orderPayTime;
	//成团时间
	private Long orderGroupSuccessTime;
	//审核时间
	private Long orderVerifyTime;
	//最后更新时间
	private Long orderModifyAt;
	//
	private Date updatetime;
	//0正常;1冻结
	private Integer status;

	/**
	 * 设置：用户id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：用户id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：订单号
	 */
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	/**
	 * 获取：订单号
	 */
	public String getOrderSn() {
		return orderSn;
	}
	/**
	 * 设置：商品id
	 */
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：商品id
	 */
	public Long getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：商品名
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * 获取：商品名
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * 设置：商品图片url
	 */
	public void setGoodsThumbnailUrl(String goodsThumbnailUrl) {
		this.goodsThumbnailUrl = goodsThumbnailUrl;
	}
	/**
	 * 获取：商品图片url
	 */
	public String getGoodsThumbnailUrl() {
		return goodsThumbnailUrl;
	}
	/**
	 * 设置：购买商品的数量
	 */
	public void setGoodsQuantity(Integer goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}
	/**
	 * 获取：购买商品的数量
	 */
	public Integer getGoodsQuantity() {
		return goodsQuantity;
	}
	/**
	 * 设置：订单中sku的单件价格，单位为分
	 */
	public void setGoodsPrice(Integer goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	/**
	 * 获取：订单中sku的单件价格，单位为分
	 */
	public Integer getGoodsPrice() {
		return goodsPrice;
	}
	/**
	 * 设置：实际支付金额，单位为分
	 */
	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}
	/**
	 * 获取：实际支付金额，单位为分
	 */
	public Integer getOrderAmount() {
		return orderAmount;
	}
	/**
	 * 设置：推广位ID
	 */
	public void setPId(String pId) {
		this.pId = pId;
	}
	/**
	 * 获取：推广位ID
	 */
	public String getPId() {
		return pId;
	}
	/**
	 * 设置：佣金比例，千分比
	 */
	public void setPromotionRate(Long promotionRate) {
		this.promotionRate = promotionRate;
	}
	/**
	 * 获取：佣金比例，千分比
	 */
	public Long getPromotionRate() {
		return promotionRate;
	}
	/**
	 * 设置：佣金金额，单位为分
	 */
	public void setPromotionAmount(Long promotionAmount) {
		this.promotionAmount = promotionAmount;
	}
	/**
	 * 获取：佣金金额，单位为分
	 */
	public Long getPromotionAmount() {
		return promotionAmount;
	}
	/**
	 * 设置：订单状态： -1 未支付;0-已支付；1-已成团；2-确认收货；3-审核成功；4-审核失败（不可提现）；5-已经结算；8-非多多进宝商品（无佣金订单）
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 获取：订单状态： -1 未支付;0-已支付；1-已成团；2-确认收货；3-审核成功；4-审核失败（不可提现）；5-已经结算；8-非多多进宝商品（无佣金订单）
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}
	/**
	 * 设置：订单状态描述
	 */
	public void setOrderStatusDesc(String orderStatusDesc) {
		this.orderStatusDesc = orderStatusDesc;
	}
	/**
	 * 获取：订单状态描述
	 */
	public String getOrderStatusDesc() {
		return orderStatusDesc;
	}
	/**
	 * 设置：订单生成时间，UNIX时间戳
	 */
	public void setOrderCreateTime(Long orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}
	/**
	 * 获取：订单生成时间，UNIX时间戳
	 */
	public Long getOrderCreateTime() {
		return orderCreateTime;
	}
	/**
	 * 设置：支付时间
	 */
	public void setOrderPayTime(Long orderPayTime) {
		this.orderPayTime = orderPayTime;
	}
	/**
	 * 获取：支付时间
	 */
	public Long getOrderPayTime() {
		return orderPayTime;
	}
	/**
	 * 设置：成团时间
	 */
	public void setOrderGroupSuccessTime(Long orderGroupSuccessTime) {
		this.orderGroupSuccessTime = orderGroupSuccessTime;
	}
	/**
	 * 获取：成团时间
	 */
	public Long getOrderGroupSuccessTime() {
		return orderGroupSuccessTime;
	}
	/**
	 * 设置：审核时间
	 */
	public void setOrderVerifyTime(Long orderVerifyTime) {
		this.orderVerifyTime = orderVerifyTime;
	}
	/**
	 * 获取：审核时间
	 */
	public Long getOrderVerifyTime() {
		return orderVerifyTime;
	}
	/**
	 * 设置：最后更新时间
	 */
	public void setOrderModifyAt(Long orderModifyAt) {
		this.orderModifyAt = orderModifyAt;
	}
	/**
	 * 获取：最后更新时间
	 */
	public Long getOrderModifyAt() {
		return orderModifyAt;
	}
	/**
	 * 设置：
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：0正常;1冻结
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：0正常;1冻结
	 */
	public Integer getStatus() {
		return status;
	}

}
