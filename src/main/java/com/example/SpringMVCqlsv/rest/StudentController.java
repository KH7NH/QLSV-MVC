package com.example.SpringMVCqlsv.rest;

import com.example.SpringMVCqlsv.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.SpringMVCqlsv.entity.Student;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/list")
    public String listAll(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/students";
    }
    @GetMapping("/create")
    public String create(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "/student/students-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student){
        studentService.updateStudent(student);
        return "redirect:/students/list";
    }
    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") Integer id, Model model) {
        // Lấy thông tin sinh viên từ service
        Student student = studentService.getStudentById(id);
        // Đưa sinh viên vào model để hiển thị trong form
        model.addAttribute("student", student);
        // Trả về view cho người dùng nhập liệu
        return "student/students-form";
    }
    @PostMapping("/students/update")
    public String updateStudent(Student student) {
        // Gọi phương thức service để cập nhật thông tin sinh viên
        studentService.updateStudent(student);
        // Sau khi cập nhật thành công, chuyển hướng về trang danh sách sinh viên
        return "redirect:/students/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id, Model model){
        studentService.deleteStudentById(id);
        return "redirect:/students/list";
    }
}
