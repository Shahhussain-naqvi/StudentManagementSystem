package Uni.studentdb.Service;

import Uni.studentdb.Entity.Student;
import Uni.studentdb.Exceptions.StudentAlreadyExistException;
import Uni.studentdb.Exceptions.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements iStudent{
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public Student addStudent(Student student) {
        if (studentAlreadyExist(student.getEmail())){
            throw new StudentAlreadyExistException(student.getEmail()+ "already exist.");
        }
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        System.out.println("this is the "+ id);
        return studentRepo.findById(id).map(st ->{
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return studentRepo.save(st);
        }).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found"));
    }

    @Override
    public void deleteStudent(Long id) {
        if(!studentRepo.existsById(id)){
            throw new StudentNotFoundException("Student not found.");
        }
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> viewStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student viewStudentById(Long id) {
        return studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Sorry, no student found with the Id :" +id));
    }

    private Boolean studentAlreadyExist(String email){
        return studentRepo.findByEmail(email).isPresent();
    }

    public void deleteAllStudent() {
        studentRepo.deleteAll();
    }
}
