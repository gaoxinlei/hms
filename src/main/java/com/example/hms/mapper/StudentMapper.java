package com.example.hms.mapper;

import com.example.hms.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    int batchInsert(@Param("students") List<Student> students);
}
