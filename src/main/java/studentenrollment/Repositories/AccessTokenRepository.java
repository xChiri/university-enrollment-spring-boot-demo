package studentenrollment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import studentenrollment.Models.AccessToken;

import java.util.List;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessToken, String> {

    public static final String FIND_AUTHENTICATED_USERS_QUERY = "SELECT user_name FROM oauth_access_token";

    @Query(value = FIND_AUTHENTICATED_USERS_QUERY, nativeQuery = true)
    public List<String> findAuthenticatedUsers();

}
