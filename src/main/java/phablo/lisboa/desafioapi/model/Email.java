package phablo.lisboa.desafioapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@javax.validation.constraints.Email
	@Column(unique = true)
	private String email;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public Email() {
	}

	public Email(String email, Client client) {
		super();
		this.email = email;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
