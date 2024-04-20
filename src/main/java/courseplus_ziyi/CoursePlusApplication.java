package courseplus_ziyi;

import courseplus_ziyi.Model.Course;
import courseplus_ziyi.Model.Lecturer;
import courseplus_ziyi.Model.Student;
import courseplus_ziyi.Model.User;
import courseplus_ziyi.Service.CourseService;
import courseplus_ziyi.Service.LecturerService;
import courseplus_ziyi.Service.StudentService;
import courseplus_ziyi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CoursePlusApplication  implements CommandLineRunner {

    @Autowired
    UserService uService;

    @Autowired
    StudentService sService;
    @Autowired
    LecturerService lService;

    @Autowired
    CourseService cService;

    public static void main(String[] args) {
        SpringApplication.run(CoursePlusApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder    ();
    }
    @Override
    public void run(String... args) throws Exception {
//        uService.save(new User("som123","som", "som123", "som@gmail.com", false, "LECTURER"));
        sService.saveStudent(new Student("Abhir","10","abhirmhjn","Abhir","abhir@gmail.com","Fall","2024"));
        sService.saveStudent(new Student("Mhjn","11","mhjn","Abhir","abhir@gmail.com","Spring","2025"));
        lService.saveLecturer(new Lecturer("prof_abc","abc","abc@gmail.com","PHD","Dr. PHD","CSE"));
        lService.saveLecturer(new Lecturer("Ass_prof_YU","yu","yu@gmail.com","MS","Dr. ZU","CSE"));
        lService.saveLecturer(new Lecturer("Prof_BAC","bac","bac@gmail.com","PHD","Dr. BAC","EM"));

        cService.saveCourse(new Course("OOD"),"prof_abc");
        cService.saveCourse(new Course("CA"),"Ass_prof_YU");
        cService.saveCourse(new Course("AI"),"Prof_BAC");
        cService.saveCourse(new Course("Intro to ML"),"Prof_BAC");
        cService.saveCourse(new Course("OOP in C++"),"prof_abc");
        cService.saveCourse(new Course("Dsta Structures"),"Ass_prof_YU");


        // To enroll courses
        sService.enrollCourse("10",Long.parseLong("2"));
        sService.enrollCourse("10",Long.parseLong("3"));
        sService.enrollCourse("10",Long.parseLong("4"));
        sService.enrollCourse("11",Long.parseLong("2"));
        sService.enrollCourse("11",Long.parseLong("3"));

//        uService.save(new User("gita","Gita", "gita", "gita@gmail.com", false, "LECTURER"));
//        uService.save(new User("anu","Gita", "anu", "anu@gmail.com", false, "STUDENT"));
//		service.saveStudent(new Student("Hari Shrestha", "1", "hari", "hari", "hari@gmail.com"));
//		service.saveStudent(new Student("Sita Sharma", "2", "sita", "sita", "hari@gmail.com"));

    }

}
