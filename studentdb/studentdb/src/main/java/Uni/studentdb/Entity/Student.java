package Uni.studentdb.Entity;


import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;


@Document


public class Student {
    @Id
    private long id;
    private String FirstName;
    private String LastName;
    private String email;
    private String Department;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        email = Email;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }


}
