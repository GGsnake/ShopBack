/**
 * Project:spring-boot
 * File:DruidStatFilter.java
 * Copyright © 2003-2016 zyqhw.com All rights reserved.
 */

package com.zyqhw.springboot.druid;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @author zhangyq
 * @date 2016年12月21日
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
initParams={
    @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
})
public class DruidStatFilter extends WebStatFilter {

}
