package com.example.demo.repository;

import com.example.demo.vo.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserVO, Integer>{

    UserVO findByUserIdAndPassword(@Param("user_id") String userId, @Param("password") String password);

    UserVO findByUserId(String userId);

    //요거는 쿼리 직접 코딩
//    @Query(value = "select * from userinfo where name = :name and password = :password", nativeQuery = true)
//    @Query("select u from UserVO u where u.name = :name and u.password = :password")
//    Page<UserVO> findAllByNameAndPassword(@Param("name") String name,@Param("password") String password,
//                                        Pageable pageable);
}
