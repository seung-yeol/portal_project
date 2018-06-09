package com.example.demo.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name= "diary")
public class DiaryVO {
    @Id
    @GeneratedValue
    private Integer id;
    private String userId;
    private String title;
    private String story;
    private String writeDate;
}
