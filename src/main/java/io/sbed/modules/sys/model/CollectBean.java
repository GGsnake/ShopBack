package io.sbed.modules.sys.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class CollectBean {
    private Integer id;
    private Double Commission;
    private String Coupon;
    private String freeShipping;
    private String interest ;
    private Double price ;
    private Double price_max ;
    private Integer salesVolume ;
    private Integer tianMou ;
    private Integer Amount ;
    private Integer opt ;
    private Integer comsaa ;
}
