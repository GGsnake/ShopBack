package io.sbed.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author heguoliang
 * @Description: TODO(商城用户表)
 * @date 2018-12-30 16:48:00
 */
public class SysUserinfo implements Serializable {
	
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
	private Integer usersex;
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
	private Integer roleid;
	//佣金比率
	private Integer score;
	//微信openid
	private String wxopenid;
	//状态
	private Integer status;

	/**
	 * 设置：用户id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：用户id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：用户名称
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名称
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：账号
	 */
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	/**
	 * 获取：账号
	 */
	public String getLoginname() {
		return loginname;
	}
	/**
	 * 设置：密码
	 */
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	/**
	 * 获取：密码
	 */
	public String getLoginpwd() {
		return loginpwd;
	}
	/**
	 * 设置：安全码
	 */
	public void setLoginsecret(Long loginsecret) {
		this.loginsecret = loginsecret;
	}
	/**
	 * 获取：安全码
	 */
	public Long getLoginsecret() {
		return loginsecret;
	}
	/**
	 * 设置：性别
	 */
	public void setUsersex(Integer usersex) {
		this.usersex = usersex;
	}
	/**
	 * 获取：性别
	 */
	public Integer getUsersex() {
		return usersex;
	}
	/**
	 * 设置：用户积分
	 */
	public void setUserscore(Integer userscore) {
		this.userscore = userscore;
	}
	/**
	 * 获取：用户积分
	 */
	public Integer getUserscore() {
		return userscore;
	}
	/**
	 * 设置：用户头像
	 */
	public void setUserphoto(String userphoto) {
		this.userphoto = userphoto;
	}
	/**
	 * 获取：用户头像
	 */
	public String getUserphoto() {
		return userphoto;
	}
	/**
	 * 设置：账号状态
	 */
	public void setUserstatus(Integer userstatus) {
		this.userstatus = userstatus;
	}
	/**
	 * 获取：账号状态
	 */
	public Integer getUserstatus() {
		return userstatus;
	}
	/**
	 * 设置：用户历史消费积分
	 */
	public void setUsertotalscore(Long usertotalscore) {
		this.usertotalscore = usertotalscore;
	}
	/**
	 * 获取：用户历史消费积分
	 */
	public Long getUsertotalscore() {
		return usertotalscore;
	}
	/**
	 * 设置：京东pid
	 */
	public void setJdpid(String jdpid) {
		this.jdpid = jdpid;
	}
	/**
	 * 获取：京东pid
	 */
	public String getJdpid() {
		return jdpid;
	}
	/**
	 * 设置：拼多多pid
	 */
	public void setPddpid(String pddpid) {
		this.pddpid = pddpid;
	}
	/**
	 * 获取：拼多多pid
	 */
	public String getPddpid() {
		return pddpid;
	}
	/**
	 * 设置：淘宝pid
	 */
	public void setTbpid(Long tbpid) {
		this.tbpid = tbpid;
	}
	/**
	 * 获取：淘宝pid
	 */
	public Long getTbpid() {
		return tbpid;
	}
	/**
	 * 设置：唯品会pid
	 */
	public void setWphpid(String wphpid) {
		this.wphpid = wphpid;
	}
	/**
	 * 获取：唯品会pid
	 */
	public String getWphpid() {
		return wphpid;
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
	 * 设置：手机
	 */
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	/**
	 * 获取：手机
	 */
	public String getUserphone() {
		return userphone;
	}
	/**
	 * 设置：身份
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	/**
	 * 获取：身份
	 */
	public Integer getRoleid() {
		return roleid;
	}
	/**
	 * 设置：佣金比率
	 */
	public void setScore(Integer score) {
		this.score = score;
	}
	/**
	 * 获取：佣金比率
	 */
	public Integer getScore() {
		return score;
	}
	/**
	 * 设置：微信openid
	 */
	public void setWxopenid(String wxopenid) {
		this.wxopenid = wxopenid;
	}
	/**
	 * 获取：微信openid
	 */
	public String getWxopenid() {
		return wxopenid;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}

}
