package Uni.studentdb.Service;

import Uni.studentdb.Entity.Student;

import java.util.List;

public interface iStudent {
    Student addStudent(Student student);
    Student updateStudent(Student student, Long id);
    void deleteStudent(Long id);
    void deleteAllStudent();
    List<Student> viewStudent();
    Student viewStudentById(Long id);

}
