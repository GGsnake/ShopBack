package io.sbed.modules.sys.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by liujupeng on 2019/1/10.
 */
@Setter
@ToString
@Getter
public class SysUserinfoDto {

    //用户id
    private Long id;
    //用户名称
    private String username;
    //账号
    private String loginname;
    //密码
    private String loginpwd;
    //安全码
    private Long loginsecret;
    //性别
    private String usersex;
    //用户积分
    private Integer userscore;
    //用户头像
    private String userphoto;
    //账号状态
    private Integer userstatus;
    //用户历史消费积分
    private Long usertotalscore;
    //京东pid
    private String jdpid;
    //拼多多pid
    private String pddpid;
    //淘宝pid
    private Long tbpid;
    //唯品会pid
    private String wphpid;
    //创建时间
    private Date createtime;
    //修改时间
    private Date updatetime;
    //手机
    private String userphone;
    //身份
    private String roleid;
    //佣金比率
    private String score;
    //微信openid
    private String wxopenid;
    //状态
    private String status;

}
