package io.sbed.modules.sys.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;

/**
 * Created by liujupeng on 2019/1/15.
 */
@Setter
@Getter
@ToString
public class JdPid {
    private Integer Id;
    private Long pid;

}
