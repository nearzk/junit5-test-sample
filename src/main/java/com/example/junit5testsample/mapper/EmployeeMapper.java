package com.example.junit5testsample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.junit5testsample.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * 雇员Mapper
 *
 * @author zhangkun
 * @time 2021/3/17 下午3:48
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
