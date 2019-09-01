package com.lu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lu.vo.Article;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {
    @Test
    public void test1() {
        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setId(2);
        article.setTitle("我的博客2");
        article.setContent("内容2");
        article.setCreate_time(new Date());
        articles.add(article);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        try {
            String result = objectMapper.writeValueAsString(articles);
            System.out.println(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
