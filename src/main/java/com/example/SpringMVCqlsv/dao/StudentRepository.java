package com.example.SpringMVCqlsv.dao;

import com.example.SpringMVCqlsv.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
