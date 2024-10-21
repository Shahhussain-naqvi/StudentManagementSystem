package Uni.studentdb.Controller;


import Uni.studentdb.Entity.Student;
import Uni.studentdb.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return  studentService.addStudent(student);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
    @DeleteMapping
    public void deleteAllStudent(){
        studentService.deleteAllStudent();
    }
    @GetMapping
    public ResponseEntity<List<Student>> viewAll(){
        return new ResponseEntity<>(studentService.viewStudent(), HttpStatus.OK);
    }
    @GetMapping("/student/{id}")
    public Student viewStudentById(@PathVariable Long id){
        return studentService.viewStudentById(id);
    }
    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id){
        return studentService.updateStudent(student,id);
    }
}
