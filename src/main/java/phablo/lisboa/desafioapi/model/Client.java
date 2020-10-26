package phablo.lisboa.desafioapi.model;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Min(3)
	@Max(100)
	@Pattern(regexp = "^[_A-z0-9]*((-|\\s)*[_A-z0-9])*$")
	private String nome;

	@NotNull
	@Pattern(regexp = "\\d{11}")
	private String cpf;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(mappedBy = "client")
	@ElementCollection
	private Set<Phone> phones;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Client() {
	}

	public Client(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
