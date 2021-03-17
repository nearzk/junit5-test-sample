package com.example.junit5testsample.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.junit5testsample.entity.Employee;
import com.example.junit5testsample.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * 雇员服务
 *
 * @author zhangkun
 * @time 2021/3/17 下午3:50
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    public String add(Employee employee) {
        int affectRows = mapper.insert(employee);
        if (affectRows > 0)
            return employee.getId();
        else
            return null;
    }

    public Employee queryOne(Employee vo) {
        return mapper.selectOne(Wrappers.<Employee>lambdaQuery()
                .eq(Employee::getId, vo.getId()).or()
                .eq(Employee::getName, vo.getName())
        );
    }

    public Boolean update(Employee employee) {
        return mapper.updateById(employee) > 0 ? true : false;
    }

    public Boolean delete(String id) {
        return mapper.deleteById(id) > 0 ? true : false;
    }
}
