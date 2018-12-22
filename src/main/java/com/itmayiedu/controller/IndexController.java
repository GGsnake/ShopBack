package com.itmayiedu.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.itmayiedu.entity.UserSchool;
import com.itmayiedu.mapper.UserSchoolMapper;
@RestController
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	//@Autowired
	//private UserDao userDao;
	
	@Autowired
	private UserSchoolMapper userSchoolMapper;

	/*@Autowired	
	private UserSchollService userSchoolService;*/
	

	//@Autowired
	//private CacheManager cacheManager;
	
	/*
	 * url:
	 * http://localhost:8080/mybatis
	 */
	@RequestMapping("/mybatis")
	public String mybatis() {
		UserSchool user = userSchoolMapper.selectByPrimaryKey(32);
		//user.getName();
		UserSchool us=new UserSchool();
		us.setName("肝胆相照");
		us.setAge(30);
		int a = userSchoolMapper.insert(us);
		 
		System.out.println("dkdkkddkkd:::::"+a);
		return "suceess";
	}
	
	@RequestMapping("/hello2")
	public String hello2() {

		return "hello2";
	}


   
	/*url:简单测试页面显示
	http://localhost:8080/
	http://localhost:8080/index
	*/
	@RequestMapping("/index")
	public String index(String name, Integer age) {
		logger.info("index .... ");
		return "index";
	}
	
	/*
          插入数据可以测试
	url:http://localhost:8080/getUserName?name=%E5%B0%8F%E8%99%8E%E4%B9%90%E9%98%9Fvv
	*/
	
	@ResponseBody
	@RequestMapping("/addUser")
	public String addUser(UserSchool userSchool) {
		userSchool.setName("小虎乐队");
		userSchool.setAge(18);
		int addUser = userSchoolMapper.insert(userSchool);
		return addUser > 0 ? "success" : "fail";
	}

	@ResponseBody
	@RequestMapping("/getUserName")
	public UserSchool getUserName(int id) {
		return userSchoolMapper.selectByPrimaryKey(id);
	}

	@RequestMapping("/remoKey")
	public void remoKey() {
		//cacheManager.getCache("baseCache").clear();
	}

	@RequestMapping("/thread")
	public void thread() throws InterruptedException {
		System.out.println("IndexController 执行开始...");
		//userServices.thread();
		System.out.println("IndexController 执行结束...");
	}

	@ResponseBody
	@RequestMapping("/getValue")
	public String getValue() {
		return "name";
	}
	
/*	
	@RequestMapping("/index")
	public String index(Integer id) {

		User findUser = userDao.findOne(id);
		System.out.println(findUser.getName());
		return "success";
	}*/
}

