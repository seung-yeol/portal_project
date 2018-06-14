package com.example.demo;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import com.example.demo.vo.DiaryVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //테스트 할때마다 포트를 랜덤하게 지정해줌
public class DiaryTest {
    private final String PATH = "/diary";
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createDiary(){
        String userId = "oks153123";
        String title = "모래";
        String story = "아버지가방에들어가신다";
        String writeDate = "1994-06-25";

        DiaryVO createDiaryVo = new DiaryVO();
        createDiaryVo.setUserId(userId);
        createDiaryVo.setTitle(title);
        createDiaryVo.setStory(story);
        createDiaryVo.setWriteDate(writeDate);

        String result = restTemplate.postForObject(PATH + "/" + "create", createDiaryVo, String.class);

        assertThat(result, is("true"));
    }
}
