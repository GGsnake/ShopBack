package io.sbed.modules.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class CollectBean {
    private Integer id;
    private String Commission;
    private String Coupon;
    private String freeShipping;
    private String interest ;
    private String price ;
    private String price_max ;
    private String salesVolume ;
    private String tianMou ;
    private String Amount ;
}
