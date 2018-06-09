package com.example.demo;

import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.MatcherAssert.*;

import com.example.demo.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //테스트 할때마다 포트를 랜덤하게 지정해줌
public class UserTest {
	private final String PATH = "/user";
	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void joinMembership() {
//		Integer id = 1;
		String userId = "oks1531234";
		String password = "1231234";
		String name = "오승열";
		String birthday = "1994.06.27";
		String phoneNum = "010-5375-0861";
		String gender = "남";

		UserVO createUserVO = new UserVO();
		createUserVO.setUserId(userId);
		createUserVO.setPassword(password);
		createUserVO.setName(name);
		createUserVO.setBirthday(birthday);
		createUserVO.setPhoneNo(phoneNum);
		createUserVO.setGender(gender);

		UserVO userVO = restTemplate.postForObject(PATH + "/" + "join_mem", createUserVO, UserVO.class);

		assertThat(userVO.getUserId(), is(userId));
		assertThat(userVO.getPassword(), is(password));
		assertThat(userVO.getName(), is(name));
		assertThat(userVO.getBirthday(), is(birthday));
		assertThat(userVO.getPhoneNo(), is(phoneNum));
		assertThat(userVO.getGender(), is(gender));
	}

	@Test
	public void login() {
		String userId = "oks1531234";
		String password = "1231234";

		UserVO loginUserVO = new UserVO();
		loginUserVO.setUserId(userId);
		loginUserVO.setPassword(password);

		restTemplate.postForObject(PATH + "/" + "login", loginUserVO, UserVO.class);
	}
}
