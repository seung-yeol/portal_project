package com.example.demo.controller;

import com.example.demo.repository.UserRepository;
import com.example.demo.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public UserVO get(@PathVariable Integer id) {
        //Optional 은 null을 넣을수도 있는 리스트라고 생각해.
        return userRepository.findById(id).get();
    }

    @PostMapping("/login")
    public UserVO login(@RequestBody UserVO userVO) {
        return userRepository.findByUserIdAndPassword(userVO.getUserId(), userVO.getPassword());
    }

    @PostMapping("/join_mem")
    public UserVO joinMembership(@RequestBody UserVO userVO) {
        return userRepository.save(userVO);
    }

//    @PostMapping("/login")
//    public UserVO create(@RequestBody UserVO userVO) {
//        return userRepository.save(userVO);
//    }

//    @GetMapping("/findExample")
//    public List<UserVO> list() {
//        return userRepository.findAll();
//    }

//    @GetMapping("/list")
//    public Page<UserVO> findExample(@RequestParam String name, @RequestParam String password,
//                                    @RequestParam Integer page, @RequestParam Integer size) {
//
//                                                                    //정렬방법         정렬 타겟
//        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "id");
//
//        return userRepository.findAllByNameAndPassword(name, password, pageRequest);
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
