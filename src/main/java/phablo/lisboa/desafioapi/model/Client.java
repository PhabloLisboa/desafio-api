package phablo.lisboa.desafioapi.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Length(max = 100, min = 3)
	@Pattern(regexp = "^[_A-z0-9]*((-|\\s)*[_A-z0-9])*$")
	private String name;

	@NotNull
	@Pattern(regexp = "\\d{11}")
	private String cpf;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	@ElementCollection
	private Set<Phone> phones;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	@ElementCollection
	private Set<Email> emails;

	public Client() {
	}

	public Client(String name, String cpf) {
		super();
		this.name = name;
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

}
