package IntegrativeProject.DentalClinic.Util;

import IntegrativeProject.DentalClinic.Entities.User;
import IntegrativeProject.DentalClinic.Entities.UserRoles;
import IntegrativeProject.DentalClinic.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String password = passwordEncoder.encode("admin");
        String password2 = passwordEncoder.encode("user");

        userRepository.save(new User("Giovanni", "giovanni", "admin@dh.com", password, UserRoles.ADMIN));
        userRepository.save(new User("Luca", "luca", "user@dh.com", password2, UserRoles.USER));
    }
}