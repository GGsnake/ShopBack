-- auto Generated on 2019-02-26
-- DROP TABLE IF EXISTS user;
CREATE TABLE user(
	create_time DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
	status INT (11) NOT NULL DEFAULT -1 COMMENT 'status',
	user_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT '用户名称',
	login_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT '账号',
	login_pwd VARCHAR (50) NOT NULL DEFAULT '' COMMENT '密码',
	login_secret VARCHAR (50) NOT NULL DEFAULT '' COMMENT '安全码',
	user_sex VARCHAR (50) NOT NULL DEFAULT '' COMMENT '性别',
	user_phone VARCHAR (50) NOT NULL DEFAULT '' COMMENT '手机',
	user_status VARCHAR (50) NOT NULL DEFAULT '' COMMENT '账号状态',
	user_score VARCHAR (50) NOT NULL DEFAULT '' COMMENT '用户积分',
	user_total_score VARCHAR (50) NOT NULL DEFAULT '' COMMENT '用户历史消费积分',
	last_time DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '最后登录时间',
	user_money BIGINT (15) NOT NULL DEFAULT -1 COMMENT '帐号余额',
	lock_money BIGINT (15) NOT NULL DEFAULT -1 COMMENT '冻结金额',
	distribut_money BIGINT (15) NOT NULL DEFAULT -1 COMMENT '佣金',
	pay_pwd VARCHAR (50) NOT NULL DEFAULT '' COMMENT '支付密码',
	wx_open_id VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'wxOpenId',
	open_id VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'openId',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user';
