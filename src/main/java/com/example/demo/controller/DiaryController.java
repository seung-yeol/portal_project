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
    public DiaryVO createDiary(@RequestBody DiaryVO diaryVO) {
        return diaryRepository.save(diaryVO);
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
}

