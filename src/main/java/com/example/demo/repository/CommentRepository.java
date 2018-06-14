package com.example.demo.repository;

import com.example.demo.vo.CommentVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentVO, Integer>{
    Page<CommentVO> findAllByDiaryId(@Param("diary_id") Integer userId, Pageable pageable);
}
