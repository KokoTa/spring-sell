package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author KokoTa
 * @create 2019/12/3
 */
@Data
@Component
@ConfigurationProperties(prefix = "custom")
public class User {
    // 没有的话不显示
    @JsonIgnore
    private String name;

    // 没有的话不显示且不能赋为 null
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT+8")
    private Date date;

    private String desc;
}
