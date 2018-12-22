/**
  * Copyright 2018 bejson.com 
  */
package io.sbed.modules.sys.entity;
import java.util.List;

/**
 * Auto-generated: 2018-11-02 16:37:53
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Goods_list {

    private Long create_at;
    private Long goods_id;
    private String goods_name;
    private String goods_desc;
    private String goods_thumbnail_url;
    private String goods_image_url;
    private String goods_gallery_urls;
    private Long sold_quantity;
    private Long min_group_price;
    private Long min_normal_price;
    private String mall_name;
    private Long merchant_type;
    private Long category_id;
    private String category_name;
    private Long opt_id;
    private String opt_name;
    private List<Long> opt_ids;
    private List<Long> cat_ids;
    private Long mall_cps;
    private boolean has_coupon;
    private Long coupon_min_order_amount;
    private Long coupon_discount;
    private Long coupon_total_quantity;
    private Long coupon_remain_quantity;
    private Long coupon_start_time;
    private Long coupon_end_time;
    private Long promotion_rate;
    private double goods_eval_score;
    private Long goods_eval_count;
    private String cat_id;
    private Long avg_desc;
    private Long avg_lgst;
    private Long avg_serv;
    private double desc_pct;
    private double lgst_pct;
    private double serv_pct;
    public void setCreate_at(Long create_at) {
         this.create_at = create_at;
     }
     public Long getCreate_at() {
         return create_at;
     }

    @Override
    public String toString() {
        return "Goods_list{" +
                "create_at=" + create_at +
                ", goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_desc='" + goods_desc + '\'' +
                ", goods_thumbnail_url='" + goods_thumbnail_url + '\'' +
                ", goods_image_url='" + goods_image_url + '\'' +
                ", goods_gallery_urls='" + goods_gallery_urls + '\'' +
                ", sold_quantity=" + sold_quantity +
                ", min_group_price=" + min_group_price +
                ", min_normal_price=" + min_normal_price +
                ", mall_name='" + mall_name + '\'' +
                ", merchant_type=" + merchant_type +
                ", category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                ", opt_id=" + opt_id +
                ", opt_name='" + opt_name + '\'' +
                ", opt_ids=" + opt_ids +
                ", cat_ids=" + cat_ids +
                ", mall_cps=" + mall_cps +
                ", has_coupon=" + has_coupon +
                ", coupon_min_order_amount=" + coupon_min_order_amount +
                ", coupon_discount=" + coupon_discount +
                ", coupon_total_quantity=" + coupon_total_quantity +
                ", coupon_remain_quantity=" + coupon_remain_quantity +
                ", coupon_start_time=" + coupon_start_time +
                ", coupon_end_time=" + coupon_end_time +
                ", promotion_rate=" + promotion_rate +
                ", goods_eval_score=" + goods_eval_score +
                ", goods_eval_count=" + goods_eval_count +
                ", cat_id='" + cat_id + '\'' +
                ", avg_desc=" + avg_desc +
                ", avg_lgst=" + avg_lgst +
                ", avg_serv=" + avg_serv +
                ", desc_pct=" + desc_pct +
                ", lgst_pct=" + lgst_pct +
                ", serv_pct=" + serv_pct +
                '}';
    }

    public void setGoods_id(Long goods_id) {
         this.goods_id = goods_id;
     }
     public Long getGoods_id() {
         return goods_id;
     }

    public void setGoods_name(String goods_name) {
         this.goods_name = goods_name;
     }
     public String getGoods_name() {
         return goods_name;
     }

    public void setGoods_desc(String goods_desc) {
         this.goods_desc = goods_desc;
     }
     public String getGoods_desc() {
         return goods_desc;
     }

    public String getGoods_thumbnail_url() {
        return goods_thumbnail_url;
    }

    public void setGoods_thumbnail_url(String goods_thumbnail_url) {
        this.goods_thumbnail_url = goods_thumbnail_url;
    }

    public String getGoods_image_url() {
        return goods_image_url;
    }

    public void setGoods_image_url(String goods_image_url) {
        this.goods_image_url = goods_image_url;
    }

    public String getGoods_gallery_urls() {
        return goods_gallery_urls;
    }

    public void setGoods_gallery_urls(String goods_gallery_urls) {
        this.goods_gallery_urls = goods_gallery_urls;
    }

    public Long getSold_quantity() {
        return sold_quantity;
    }

    public void setSold_quantity(Long sold_quantity) {
        this.sold_quantity = sold_quantity;
    }

    public Long getMin_group_price() {
        return min_group_price;
    }

    public void setMin_group_price(Long min_group_price) {
        this.min_group_price = min_group_price;
    }

    public Long getMin_normal_price() {
        return min_normal_price;
    }

    public void setMin_normal_price(Long min_normal_price) {
        this.min_normal_price = min_normal_price;
    }

    public String getMall_name() {
        return mall_name;
    }

    public void setMall_name(String mall_name) {
        this.mall_name = mall_name;
    }

    public Long getMerchant_type() {
        return merchant_type;
    }

    public void setMerchant_type(Long merchant_type) {
        this.merchant_type = merchant_type;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Long getOpt_id() {
        return opt_id;
    }

    public void setOpt_id(Long opt_id) {
        this.opt_id = opt_id;
    }

    public String getOpt_name() {
        return opt_name;
    }

    public void setOpt_name(String opt_name) {
        this.opt_name = opt_name;
    }

    public List<Long> getOpt_ids() {
        return opt_ids;
    }

    public void setOpt_ids(List<Long> opt_ids) {
        this.opt_ids = opt_ids;
    }

    public List<Long> getCat_ids() {
        return cat_ids;
    }

    public void setCat_ids(List<Long> cat_ids) {
        this.cat_ids = cat_ids;
    }

    public Long getMall_cps() {
        return mall_cps;
    }

    public void setMall_cps(Long mall_cps) {
        this.mall_cps = mall_cps;
    }

    public boolean isHas_coupon() {
        return has_coupon;
    }

    public void setHas_coupon(boolean has_coupon) {
        this.has_coupon = has_coupon;
    }

    public Long getCoupon_min_order_amount() {
        return coupon_min_order_amount;
    }

    public void setCoupon_min_order_amount(Long coupon_min_order_amount) {
        this.coupon_min_order_amount = coupon_min_order_amount;
    }

    public Long getCoupon_discount() {
        return coupon_discount;
    }

    public void setCoupon_discount(Long coupon_discount) {
        this.coupon_discount = coupon_discount;
    }

    public Long getCoupon_total_quantity() {
        return coupon_total_quantity;
    }

    public void setCoupon_total_quantity(Long coupon_total_quantity) {
        this.coupon_total_quantity = coupon_total_quantity;
    }

    public Long getCoupon_remain_quantity() {
        return coupon_remain_quantity;
    }

    public void setCoupon_remain_quantity(Long coupon_remain_quantity) {
        this.coupon_remain_quantity = coupon_remain_quantity;
    }

    public Long getCoupon_start_time() {
        return coupon_start_time;
    }

    public void setCoupon_start_time(Long coupon_start_time) {
        this.coupon_start_time = coupon_start_time;
    }

    public Long getCoupon_end_time() {
        return coupon_end_time;
    }

    public void setCoupon_end_time(Long coupon_end_time) {
        this.coupon_end_time = coupon_end_time;
    }

    public Long getPromotion_rate() {
        return promotion_rate;
    }

    public void setPromotion_rate(Long promotion_rate) {
        this.promotion_rate = promotion_rate;
    }

    public double getGoods_eval_score() {
        return goods_eval_score;
    }

    public void setGoods_eval_score(double goods_eval_score) {
        this.goods_eval_score = goods_eval_score;
    }

    public Long getGoods_eval_count() {
        return goods_eval_count;
    }

    public void setGoods_eval_count(Long goods_eval_count) {
        this.goods_eval_count = goods_eval_count;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public Long getAvg_desc() {
        return avg_desc;
    }

    public void setAvg_desc(Long avg_desc) {
        this.avg_desc = avg_desc;
    }

    public Long getAvg_lgst() {
        return avg_lgst;
    }

    public void setAvg_lgst(Long avg_lgst) {
        this.avg_lgst = avg_lgst;
    }

    public Long getAvg_serv() {
        return avg_serv;
    }

    public void setAvg_serv(Long avg_serv) {
        this.avg_serv = avg_serv;
    }

    public double getDesc_pct() {
        return desc_pct;
    }

    public void setDesc_pct(double desc_pct) {
        this.desc_pct = desc_pct;
    }

    public double getLgst_pct() {
        return lgst_pct;
    }

    public void setLgst_pct(double lgst_pct) {
        this.lgst_pct = lgst_pct;
    }

    public double getServ_pct() {
        return serv_pct;
    }

    public void setServ_pct(double serv_pct) {
        this.serv_pct = serv_pct;
    }
}