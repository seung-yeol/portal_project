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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //테스트 할때마다 포트를 랜덤하게 지정해줌
public class UserTest {
	private final String PATH = "/user";
	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void joinMembership() {
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

		Boolean mBoolean = restTemplate.postForObject(PATH + "/" + "join_mem", createUserVO, Boolean.class);

		assertThat(mBoolean, is(true));

		String userId2 = "oks1531234";
		String password2 = "1231234";
		String name2 = "오승열";
		String gender2 = "남";

		UserVO createUserVO2 = new UserVO();
		createUserVO2.setUserId(userId2);
		createUserVO2.setPassword(password2);
		createUserVO2.setName(name2);
		createUserVO2.setGender(gender2);

		Boolean mBoolean2 = restTemplate.postForObject(PATH + "/" + "join_mem", createUserVO2, Boolean.class);

		assertThat(mBoolean2, is(false));
	}

	@Test
	public void login() {
		String userId = "oks153123";
		String password = "123123";
		String userId2 = "fasdfascx";
		String password2 = "asdfavxcz";

		//variable에 들어갈 내용을 Map에다 넣음. HashMap 사용하면 안됨. 그 이유는 나중에 검색해봐
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("userId", userId);
		map.add("password", password);

		MultiValueMap<String, String> map2 = new LinkedMultiValueMap<>();
		map2.add("userId", userId2);
		map2.add("password", password2);

		Boolean mBoolean = restTemplate.postForObject(PATH + "/" + "login",  map, Boolean.class);
		Boolean mBoolean2 = restTemplate.postForObject(PATH + "/" + "login",  map2, Boolean.class);

		assertThat(mBoolean, is(true));
		assertThat(mBoolean2, is(false));
	}

	@Test
	public void sameIdCheck() {
		String userId = "oks153123";

		String result = restTemplate.getForObject(PATH + "/" + "same/"+userId, String.class);

		assertThat(result, not("true"));
	}
}
