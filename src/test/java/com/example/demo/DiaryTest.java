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
        String title = "오늘";
        String story = "아버지가방에들어가신다";
        String writeDate = "1994-06-26";

        DiaryVO createDiaryVo = new DiaryVO();
        createDiaryVo.setUserId(userId);
        createDiaryVo.setTitle(title);
        createDiaryVo.setStory(story);
        createDiaryVo.setWriteDate(writeDate);

        DiaryVO diaryVO = restTemplate.postForObject(PATH + "/" + "create", createDiaryVo, DiaryVO.class);

        assertThat(diaryVO.getUserId(), is(userId));
        assertThat(diaryVO.getTitle(), is(title));
        assertThat(diaryVO.getStory(), is(story));
        assertThat(diaryVO.getWriteDate(), is(writeDate));
    }

//    @Test
//    public void readDiary(){
//        String userId = "oks153123";
//
//        Page<DiaryVO> diaryVOPage = restTemplate.getForObject(PATH + "/" + "read/my/" + userId+"/"+"0", Page.class);
//        List<DiaryVO> vos =  diaryVOPage.getContent();
//
//        assertThat( vos.get(0).getUserId() , is(userId) );
//        assertThat( vos.get(0).getTitle() , notNullValue());
//        assertThat( vos.get(0).getStory() , notNullValue());
//    }
}
