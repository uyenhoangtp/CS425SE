package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentMgmtApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // create sample data
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/M/d");
        Student s1 = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.parse("2019/5/24", f));

        Transcript t1 = new Transcript("BS Computer Science");
        s1.setTranscript(t1);

        Classroom c1 = new Classroom("McLaughlin building", "M105");
        s1.setClassroom(c1);

        Student saved = saveStudentAndReturn(s1);

        System.out.println("Saved student: " + saved);

        // exit application
        System.exit(0);
    }

    public Student saveStudentAndReturn(Student student) {
        return studentRepository.save(student);
    }
}
