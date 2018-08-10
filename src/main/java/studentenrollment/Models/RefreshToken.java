
package studentenrollment.Models;

import javax.persistence.*;

@Entity
@Table(name = "oauth_refresh_token")
public class RefreshToken {

    @Id
	@Column(name="token_id")
    private String tokenId;

    @Column(name="token")
    @Lob
	@Basic(fetch= FetchType.LAZY)
    private String token;


    @Column(name="authentication")
    @Lob
	@Basic(fetch=FetchType.LAZY)
    private String authentication; 


    public RefreshToken() { }

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}
}
