package Uni.studentdb.Service;
import Uni.studentdb.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface StudentRepo extends MongoRepository<Student,Long>{

    Optional<Student> findByEmail(String Email);


}
