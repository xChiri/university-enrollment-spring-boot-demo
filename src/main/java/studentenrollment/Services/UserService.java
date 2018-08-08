package studentenrollment.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import studentenrollment.Models.User;
import studentenrollment.Repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw  new UsernameNotFoundException(username + " was not found");
        System.out.println("User loaded: " + user.getUsername() + " " + user.getPassword());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRoles()));

    }
}
