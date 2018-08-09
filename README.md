# University Enrollment Spring Boot + Spring Security + Oauth2 Demo
<p> A Spring Boot REST API that implements OAuth2 (password grant type) authentication with Spring Security. </p>

== To add a user
<p> In order to add a user, modify the overriden run() method in the DbPopulator and annotate it with @Component. </p>
</p> Also, a user can be registered by sending a POST request to /signUp with the username and password contained in the request body.

== Access tokens

<p> To generate the oauth_access_token and oauth_refresh_token tables use the following: 

<code>
create table oauth_access_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication BLOB,
  refresh_token VARCHAR(255)
);
  </code>

create table oauth_refresh_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication BLOB
);

</p>

To authenticate, send a request to obtain an access token:

curl test:secret@localhost:8080/oauth/token -d grant_type=password -d username=chiri -d password=pass
(change the credentials accordingly)

To obtain a new access token after expiration, send the refresh_token using the following request:

curl test:secret@localhost:8080/oauth/token -d grant_type=refresh_token -d refresh_token=8637587b-fb62-4a1f-9b03-3305f13fe399
