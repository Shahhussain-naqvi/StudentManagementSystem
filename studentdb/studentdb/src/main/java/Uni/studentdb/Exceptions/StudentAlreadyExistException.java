package Uni.studentdb.Exceptions;

public class StudentAlreadyExistException extends RuntimeException{


    public StudentAlreadyExistException(String message) {
        super(message);
    }
}
