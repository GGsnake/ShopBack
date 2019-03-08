package io.sbed.modules.sys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author heguoliang
 * @Description: TODO(京东订单表)
 * @date 2019-02-23 16:19:01
 */
public class SysJdoder implements Serializable {
	
	//
	private Integer id;
	//京东pid
	private String positionid;
	//1
	private BigDecimal actualcosprice;
	//推客获得的实际佣金
	private BigDecimal actualfee;
	//佣金比例
	private BigDecimal commissionrate;
	//预估计佣金额
	private BigDecimal estimatecosprice;
	//推客的预估佣金额
	private BigDecimal estimatefee;
	//最终比例
	private BigDecimal finalrate;
	//商品单价
	private BigDecimal price;
	//商品Id
	private Long skuid;
	//商品名称
	private String skuname;
	//订单ID
	private Long orderid;
	//结算时间
	private Long paymonth;
	//订单完成时间
	private Long finishtime;
	//下单时间
	private Long ordertime;
	//15.待付款,16.已付款,17.已完成,18.已结算
	private Integer validcode;
	//创建时间
	private Date createtime;
	//修改时间
	private Date updatetime;
	//结算状态
	private Integer settle;

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
	 * 设置：京东pid
	 */
	public void setPositionid(String positionid) {
		this.positionid = positionid;
	}
	/**
	 * 获取：京东pid
	 */
	public String getPositionid() {
		return positionid;
	}
	/**
	 * 设置：1
	 */
	public void setActualcosprice(BigDecimal actualcosprice) {
		this.actualcosprice = actualcosprice;
	}
	/**
	 * 获取：1
	 */
	public BigDecimal getActualcosprice() {
		return actualcosprice;
	}
	/**
	 * 设置：推客获得的实际佣金
	 */
	public void setActualfee(BigDecimal actualfee) {
		this.actualfee = actualfee;
	}
	/**
	 * 获取：推客获得的实际佣金
	 */
	public BigDecimal getActualfee() {
		return actualfee;
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
	 * 设置：预估计佣金额
	 */
	public void setEstimatecosprice(BigDecimal estimatecosprice) {
		this.estimatecosprice = estimatecosprice;
	}
	/**
	 * 获取：预估计佣金额
	 */
	public BigDecimal getEstimatecosprice() {
		return estimatecosprice;
	}
	/**
	 * 设置：推客的预估佣金额
	 */
	public void setEstimatefee(BigDecimal estimatefee) {
		this.estimatefee = estimatefee;
	}
	/**
	 * 获取：推客的预估佣金额
	 */
	public BigDecimal getEstimatefee() {
		return estimatefee;
	}
	/**
	 * 设置：最终比例
	 */
	public void setFinalrate(BigDecimal finalrate) {
		this.finalrate = finalrate;
	}
	/**
	 * 获取：最终比例
	 */
	public BigDecimal getFinalrate() {
		return finalrate;
	}
	/**
	 * 设置：商品单价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：商品单价
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：商品Id
	 */
	public void setSkuid(Long skuid) {
		this.skuid = skuid;
	}
	/**
	 * 获取：商品Id
	 */
	public Long getSkuid() {
		return skuid;
	}
	/**
	 * 设置：商品名称
	 */
	public void setSkuname(String skuname) {
		this.skuname = skuname;
	}
	/**
	 * 获取：商品名称
	 */
	public String getSkuname() {
		return skuname;
	}
	/**
	 * 设置：订单ID
	 */
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	/**
	 * 获取：订单ID
	 */
	public Long getOrderid() {
		return orderid;
	}
	/**
	 * 设置：结算时间
	 */
	public void setPaymonth(Long paymonth) {
		this.paymonth = paymonth;
	}
	/**
	 * 获取：结算时间
	 */
	public Long getPaymonth() {
		return paymonth;
	}
	/**
	 * 设置：订单完成时间
	 */
	public void setFinishtime(Long finishtime) {
		this.finishtime = finishtime;
	}
	/**
	 * 获取：订单完成时间
	 */
	public Long getFinishtime() {
		return finishtime;
	}
	/**
	 * 设置：下单时间
	 */
	public void setOrdertime(Long ordertime) {
		this.ordertime = ordertime;
	}
	/**
	 * 获取：下单时间
	 */
	public Long getOrdertime() {
		return ordertime;
	}
	/**
	 * 设置：15.待付款,16.已付款,17.已完成,18.已结算
	 */
	public void setValidcode(Integer validcode) {
		this.validcode = validcode;
	}
	/**
	 * 获取：15.待付款,16.已付款,17.已完成,18.已结算
	 */
	public Integer getValidcode() {
		return validcode;
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
	/**
	 * 设置：结算状态
	 */
	public void setSettle(Integer settle) {
		this.settle = settle;
	}
	/**
	 * 获取：结算状态
	 */
	public Integer getSettle() {
		return settle;
	}

}
