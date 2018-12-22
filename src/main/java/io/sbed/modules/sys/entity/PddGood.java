package io.sbed.modules.sys.entity;

/**
 * Created by liujupeng on 2018/11/3.
 */
public class PddGood {
    private Long goods_id;
    private Long create_at;
    private String goods_name;
    private String goods_desc;
    private String goods_thumbnail_url;
    private Long sold_quantity;
    private String mall_name;
    private Long coupon_discount;

    @Override
    public String toString() {
        return "PddGood{" +
                "goods_id=" + goods_id +
                ", create_at=" + create_at +
                ", goods_name='" + goods_name + '\'' +
                ", goods_desc='" + goods_desc + '\'' +
                ", goods_thumbnail_url='" + goods_thumbnail_url + '\'' +
                ", sold_quantity=" + sold_quantity +
                ", mall_name='" + mall_name + '\'' +
                ", coupon_discount=" + coupon_discount +
                ", promotion_rate=" + promotion_rate +
                '}';
    }

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc;
    }

    public String getGoods_thumbnail_url() {
        return goods_thumbnail_url;
    }

    public void setGoods_thumbnail_url(String goods_thumbnail_url) {
        this.goods_thumbnail_url = goods_thumbnail_url;
    }

    public Long getSold_quantity() {
        return sold_quantity;
    }

    public void setSold_quantity(Long sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public String getMall_name() {
        return mall_name;
    }

    public void setMall_name(String mall_name) {
        this.mall_name = mall_name;
    }

    public Long getCoupon_discount() {
        return coupon_discount;
    }

    public void setCoupon_discount(Long coupon_discount) {
        this.coupon_discount = coupon_discount;
    }

    public Long getPromotion_rate() {
        return promotion_rate;
    }

    public void setPromotion_rate(Long promotion_rate) {
        this.promotion_rate = promotion_rate;
    }

    private Long promotion_rate;

}
