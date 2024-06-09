package com.example.SpringMVCqlsv.service;

import com.example.SpringMVCqlsv.entity.Student;


import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudentById(int id);

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void deleteStudentById(int id);

}
