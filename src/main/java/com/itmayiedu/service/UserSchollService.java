package com.itmayiedu.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.itmayiedu.entity.UserSchool;
import com.itmayiedu.mapper.UserSchoolMapper;

@Service
public class UserSchollService {
	@Autowired
	private UserSchoolMapper userSchoolMapper;

	@Transactional
	public int addUser(UserSchool userSchool) {
		int i = userSchoolMapper.insert(userSchool);
		// int j=1/0;
		return i;
	}

	@Async
	public void thread() throws InterruptedException {
		System.out.println("开始执行...");
		Thread.sleep(10000);
		System.out.println("结束执行...");
	}
}

