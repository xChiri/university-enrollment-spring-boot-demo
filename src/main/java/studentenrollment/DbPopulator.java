package studentenrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import studentenrollment.Models.User;
import studentenrollment.Repositories.UserRepository;

//@Component
public class DbPopulator implements ApplicationRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(ApplicationArguments args) {
        repository.save(new User("chiri", "pass", true, new String[] {"USER"}));
    }
}
