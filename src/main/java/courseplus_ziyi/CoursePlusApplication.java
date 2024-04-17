package courseplus_ziyi;

import courseplus_ziyi.Model.User;
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

    public static void main(String[] args) {
        SpringApplication.run(CoursePlusApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder    ();
    }
    @Override
    public void run(String... args) throws Exception {
        uService.save(new User("som123", "som123", "som@gmail.com", false, "LECTURER"));
        uService.save(new User("gita", "gita", "gita@gmail.com", false, "LECTURER"));
        uService.save(new User("anu", "anu", "anu@gmail.com", false, "STUDENT"));
//		service.saveStudent(new Student("Hari Shrestha", "1", "hari", "hari", "hari@gmail.com"));
//		service.saveStudent(new Student("Sita Sharma", "2", "sita", "sita", "hari@gmail.com"));

    }

}
