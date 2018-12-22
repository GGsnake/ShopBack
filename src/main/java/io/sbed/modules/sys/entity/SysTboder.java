package io.sbed.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author heguoliang
 * @Description: TODO(淘宝订单表)
 * @date 2018-12-20 10:12:57
 */
public class SysTboder implements Serializable {
	
	//
	private Integer id;
	//推广位Id
	private Long adzoneId;
	//推广位名称
	private String adzoneName;
	//付款金额
	private String alipayTotalPrice;
	//推广者获得的收入金，
	private Long commission;
	//推广者获得的分成比率
	private String commissionRate;
	//平台类型
	private String orderType;
	//商品标题
	private String itemTitle;
	//商品数量
	private Long itemNum;
	//商品id
	private Long numIid;
	//实际支付金额
	private String payPrice;
	//原价
	private String price;
	//淘客订单状态，3：订单结算，12：订单付款， 13：订单失效，14：订单成功
	private Integer tkStatus;
	//来源媒体ID
	private String siteId;
	//来源媒体名称
	private String siteName;
	//佣金比率
	private String totalCommissionRate;
	//  淘宝订单号
	private Long tradeId;
	//淘宝父订单号
	private Long tradeParentId;
	//订单创建时间
	private Date odercreateTime;
	//创建时间
	private Date createtime;
	//修改时间
	private Date updatetime;

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
	 * 设置：推广位Id
	 */
	public void setAdzoneId(Long adzoneId) {
		this.adzoneId = adzoneId;
	}
	/**
	 * 获取：推广位Id
	 */
	public Long getAdzoneId() {
		return adzoneId;
	}
	/**
	 * 设置：推广位名称
	 */
	public void setAdzoneName(String adzoneName) {
		this.adzoneName = adzoneName;
	}
	/**
	 * 获取：推广位名称
	 */
	public String getAdzoneName() {
		return adzoneName;
	}
	/**
	 * 设置：付款金额
	 */
	public void setAlipayTotalPrice(String alipayTotalPrice) {
		this.alipayTotalPrice = alipayTotalPrice;
	}
	/**
	 * 获取：付款金额
	 */
	public String getAlipayTotalPrice() {
		return alipayTotalPrice;
	}
	/**
	 * 设置：推广者获得的收入金，
	 */
	public void setCommission(Long commission) {
		this.commission = commission;
	}
	/**
	 * 获取：推广者获得的收入金，
	 */
	public Long getCommission() {
		return commission;
	}
	/**
	 * 设置：推广者获得的分成比率
	 */
	public void setCommissionRate(String commissionRate) {
		this.commissionRate = commissionRate;
	}
	/**
	 * 获取：推广者获得的分成比率
	 */
	public String getCommissionRate() {
		return commissionRate;
	}
	/**
	 * 设置：平台类型
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：平台类型
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * 设置：商品标题
	 */
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	/**
	 * 获取：商品标题
	 */
	public String getItemTitle() {
		return itemTitle;
	}
	/**
	 * 设置：商品数量
	 */
	public void setItemNum(Long itemNum) {
		this.itemNum = itemNum;
	}
	/**
	 * 获取：商品数量
	 */
	public Long getItemNum() {
		return itemNum;
	}
	/**
	 * 设置：商品id
	 */
	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}
	/**
	 * 获取：商品id
	 */
	public Long getNumIid() {
		return numIid;
	}
	/**
	 * 设置：实际支付金额
	 */
	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
	}
	/**
	 * 获取：实际支付金额
	 */
	public String getPayPrice() {
		return payPrice;
	}
	/**
	 * 设置：原价
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 获取：原价
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 设置：淘客订单状态，3：订单结算，12：订单付款， 13：订单失效，14：订单成功
	 */
	public void setTkStatus(Integer tkStatus) {
		this.tkStatus = tkStatus;
	}
	/**
	 * 获取：淘客订单状态，3：订单结算，12：订单付款， 13：订单失效，14：订单成功
	 */
	public Integer getTkStatus() {
		return tkStatus;
	}
	/**
	 * 设置：来源媒体ID
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	/**
	 * 获取：来源媒体ID
	 */
	public String getSiteId() {
		return siteId;
	}
	/**
	 * 设置：来源媒体名称
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	/**
	 * 获取：来源媒体名称
	 */
	public String getSiteName() {
		return siteName;
	}
	/**
	 * 设置：佣金比率
	 */
	public void setTotalCommissionRate(String totalCommissionRate) {
		this.totalCommissionRate = totalCommissionRate;
	}
	/**
	 * 获取：佣金比率
	 */
	public String getTotalCommissionRate() {
		return totalCommissionRate;
	}
	/**
	 * 设置：  淘宝订单号
	 */
	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}
	/**
	 * 获取：  淘宝订单号
	 */
	public Long getTradeId() {
		return tradeId;
	}
	/**
	 * 设置：淘宝父订单号
	 */
	public void setTradeParentId(Long tradeParentId) {
		this.tradeParentId = tradeParentId;
	}
	/**
	 * 获取：淘宝父订单号
	 */
	public Long getTradeParentId() {
		return tradeParentId;
	}
	/**
	 * 设置：订单创建时间
	 */
	public void setOdercreateTime(Date odercreateTime) {
		this.odercreateTime = odercreateTime;
	}
	/**
	 * 获取：订单创建时间
	 */
	public Date getOdercreateTime() {
		return odercreateTime;
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
	 * 设置：修改时间
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdatetime() {
		return updatetime;
	}

}
