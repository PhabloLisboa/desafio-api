package phablo.lisboa.desafioapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String username;

	@NotNull
	@JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@OneToOne(mappedBy = "user")
	private Client client;

	public User() {
	}

	public User(@NotNull String username, @NotNull String password) {
		super();
		this.username = username;
		this.password = new BCryptPasswordEncoder().encode(password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
