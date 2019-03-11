package io.sbed.modules.sys.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Config {
    private Integer id;
    private String ConfigNo;
    private String ConfigName;
    private String ConfigValue;
    private String Remark ;
    private String EditBy ;
    private String EditTime ;
}
