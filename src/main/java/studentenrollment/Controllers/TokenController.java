package studentenrollment.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.web.bind.annotation.*;
import studentenrollment.Models.AccessToken;
import studentenrollment.Repositories.AccessTokenRepository;

import java.util.List;

@RestController
public class TokenController {

    @Autowired
    private AccessTokenRepository accessTokenRepository;

    @GetMapping("/token")
    public List<AccessToken> index()
    {
        return accessTokenRepository.findAll();
    }

    @GetMapping("/token/users")
    public List<String> authenticatedUsers()
    {
        return accessTokenRepository.findAuthenticatedUsers();
    }

    @Autowired
    private DefaultTokenServices tokenServices;

    @GetMapping("/token/revoke")
    public void revoke(@RequestHeader("Authorization") String header)
    {
        String tokenValue = header.replace("Bearer", "").trim();
        tokenServices.revokeToken(tokenValue);
    }



}
