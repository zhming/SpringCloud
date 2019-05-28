package com.example.mybatis;

import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {
	@Autowired
	private UserMapper userMapper;


	@Test
	public void contextLoads() {
		List<User> users = userMapper.findAll();
		assertTrue(2 == users.size());
	}

}
