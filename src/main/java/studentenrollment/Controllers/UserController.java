package studentenrollment.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import studentenrollment.Models.User;
import studentenrollment.Repositories.UserRepository;

import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signUp")
    public User signUp(@RequestBody HashMap<String, String> body)
    {
        String username = body.get("username");
        String password = body.get("password");
        String[] roles = {"USER"};

        User user = new User(username, password, true, roles);

        System.out.println("User:" + user.getUsername() + " " + user.getPassword());
        return userRepository.save(user);
    }

    @GetMapping("/loggedInUser")
    public Object loggedInUser()
    {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
