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
public class Goods_search_response {

    private List<Goods_list> goods_list;
    private int total_count;
    public void setGoods_list(List<Goods_list> goods_list) {
         this.goods_list = goods_list;
     }
     public List<Goods_list> getGoods_list() {
         return goods_list;
     }

    public void setTotal_count(int total_count) {
         this.total_count = total_count;
     }
     public int getTotal_count() {
         return total_count;
     }

}