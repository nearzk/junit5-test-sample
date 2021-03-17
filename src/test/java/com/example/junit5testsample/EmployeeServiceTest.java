package com.example.junit5testsample;

import com.example.junit5testsample.entity.Employee;
import com.example.junit5testsample.service.EmployeeService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 雇员服务单元测试
 *
 * @author zhangkun
 * @time 2021/3/17 下午4:22
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;

    @Test
    @Order(1)
    void testAdd(){
        Employee employee = new Employee("1", "zhangsan", 100, "13666666666");
        String id = service.add(employee);
        Assertions.assertEquals("1", id);
    }

    @Test
    @Order(2)
    void testQuery() {
        Employee one = service.queryOne(new Employee("1", "zhangsan", null, null));
        Assertions.assertNotNull(one);
    }

    @Test
    @Order(3)
    void testUpdate(){
        Assertions.assertTrue(service.update(new Employee("1", "zhangsan", 101, "18888888888")));
        Employee one = service.queryOne(new Employee("1", "zhangsan", null, null));
        Assertions.assertEquals(101, one.getAge());
        Assertions.assertEquals("18888888888", one.getContact());
    }

    @Test
    @Order(4)
    void testDelete(){
        Assertions.assertTrue(service.delete("1"));
        Employee one = service.queryOne(new Employee("1", "zhangsan", null, null));
        Assertions.assertNull(one);
    }
}
