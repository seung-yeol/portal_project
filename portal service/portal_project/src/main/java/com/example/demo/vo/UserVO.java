package com.example.demo.vo;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name= "user")
public class UserVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private String userId;
    private String name;
    private String birthday;
    private String password;
    @Column(name = "phone_no")
    private String phoneNo;
    private String gender;
}
