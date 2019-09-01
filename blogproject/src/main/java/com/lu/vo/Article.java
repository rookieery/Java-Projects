package com.lu.vo;

import lombok.Data;

import java.util.Date;
@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Date create_time;
    private String userAccout;
}
