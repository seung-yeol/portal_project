package com.example.demo.vo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name= "diary")
public class DiaryVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private String userId;
    private String title;
    private String story;
    @Column(name = "write_date")
    private String writeDate;
}
