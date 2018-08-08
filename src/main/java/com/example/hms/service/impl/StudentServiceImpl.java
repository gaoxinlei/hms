package com.example.hms.service.impl;

import com.example.hms.mapper.StudentMapper;
import com.example.hms.model.Student;
import com.example.hms.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 高鑫磊
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @mobile 15120076052
 * @created 2018/7/27 下午7:56
 * @changeRecord
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Override
    public void batchInsert(List<Student> students) {
        int number = studentMapper.batchInsert(students);
        System.out.println("插入数量:"+number);
    }
}
