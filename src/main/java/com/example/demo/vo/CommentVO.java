package com.example.demo.vo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name= "comment")
public class CommentVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "diary_id")
    private Integer diaryId;
    private String comment;
    @Column(name = "write_date")
    private String writeDate;
}
