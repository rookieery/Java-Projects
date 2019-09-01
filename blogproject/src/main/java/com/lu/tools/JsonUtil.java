package com.lu.tools;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lu.exception.SystemException;


import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

public class JsonUtil {
    public static String format(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new SystemException("json解析错误" + obj);
        }
    }

    public static <T> T get(HttpServletRequest request, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        try {
            return objectMapper.readValue(request.getInputStream(),clazz);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException("json反序列化失败");
        }
    }
}
