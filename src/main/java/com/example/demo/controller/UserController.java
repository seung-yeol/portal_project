package com.example.demo.controller;

import com.example.demo.repository.UserRepository;
import com.example.demo.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user", consumes = {MediaType.ALL_VALUE, MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_FORM_URLENCODED_VALUE})
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public UserVO get(@PathVariable Integer id) {
        //Optional 은 null을 넣을수도 있는 리스트라고 생각해.
        return userRepository.findById(id).get();
    }

    @PostMapping("/login")
    public boolean login(@RequestParam String userId, @RequestParam String password) {
        return userRepository.findByUserIdAndPassword(userId, password) != null;
    }

    @PostMapping("/join_mem")
    public boolean joinMembership(@RequestBody UserVO userVO) {
        if (userVO.getUserId() == null || userVO.getPassword() == null || userVO.getBirthday() == null ||
                userVO.getGender() == null || userVO.getPhoneNo() == null || userVO.getName() == null)
            return false;
        else {
            userRepository.save(userVO);
            return true;
        }
    }

//    @PostMapping("/login")
//    public UserVO create(@RequestBody UserVO userVO) {
//        return userRepository.save(userVO);
//    }

//    @GetMapping("/findExample")
//    public List<UserVO> list() {
//        return userRepository.findAll();
//    }

//    @PutMapping
//    public void modify(@RequestBody UserVO userVO) {
//        userRepository.save(userVO);
//    }
//
//    @DeleteMapping
//    public void delete(@PathVariable Integer id) {
//        userRepository.delete(userRepository.findById(id).get());
//    }
}
