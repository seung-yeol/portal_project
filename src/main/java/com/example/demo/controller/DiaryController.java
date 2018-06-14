package com.example.demo.controller;


import com.example.demo.repository.DiaryRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.vo.DiaryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryRepository diaryRepository;

    @PostMapping("/create")
    public String createDiary(@RequestBody DiaryVO diaryVO) {
        if (diaryVO.getUserId() == null)
            return "userId is null";
        else if (diaryVO.getTitle() == null)
            return "title is null";
        else if (diaryVO.getStory() == null)
            return "story is null";
        else if (diaryVO.getWriteDate() == null)
            return "writeDate is null";
        else {
            diaryRepository.save(diaryVO);
            return "true";
        }
    }

    @GetMapping("/read/my/{userId}/{page}")
    public Page<DiaryVO> readAll(@PathVariable String userId, @PathVariable Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.Direction.ASC, "writeDate");

        return diaryRepository.findAllByUserId(userId, pageRequest);
    }

    @GetMapping("/read/random")
    public List<DiaryVO> readRandom(){
        return diaryRepository.findByRandom();
    }

    @GetMapping("/writeEnableCheck/{userId}/{writeDate}")
    public String writeEnableCheck(@PathVariable String userId, @PathVariable String writeDate){
        if (diaryRepository.countByUserIdAndWriteDate(userId, writeDate) == 0){
            return "true";
        }
        else return "오늘 일기를 이미 작성하셨습니다.";
    }

}

