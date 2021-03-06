package com.example.junit5testsample.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ιε
 *
 * @author zhangkun
 * @time 2021/3/17 δΈε3:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_employee")
public class Employee {
    private String id;
    private String name;
    private Integer age;
    private String contact;
}
