package com.example.demo.controller;


import com.example.demo.repository.CommentRepository;
import com.example.demo.vo.CommentVO;
import com.example.demo.vo.DiaryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository commentRepository;

    @PostMapping("/create")
    public String createComment(@RequestBody CommentVO commentVO) {
        if (commentVO.getUserId() == null)
            return "userId is null";
        else if (commentVO.getDiaryId() == null)
            return "diaryId is null";
        else if (commentVO.getComment() == null)
            return "content is null";
        else if (commentVO.getWriteDate() == null)
            return "writeDate is null";
        else {
            commentRepository.save(commentVO);
            return "true";
        }
    }

    @GetMapping("/read/{diaryId}/{page}")
    public Page<CommentVO> readComment(@PathVariable Integer diaryId, @PathVariable Integer page){
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.Direction.ASC, "id");

        return commentRepository.findAllByDiaryId(diaryId, pageRequest);
    }

}

