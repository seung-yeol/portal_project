package com.example.demo.repository;

import com.example.demo.vo.DiaryVO;
import com.example.demo.vo.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface DiaryRepository extends JpaRepository<DiaryVO, Integer> {
    Page<DiaryVO> findAllByUserId(@Param("user_id") String userId, Pageable pageable);

    @Query( value = "select * from diary Order BY RAND() LIMIT 7", nativeQuery = true)
    List<DiaryVO> findByRandom();

    Integer countByUserIdAndWriteDate(@Param("user_id") String userId,@Param("write_date") String writeDate);
}
