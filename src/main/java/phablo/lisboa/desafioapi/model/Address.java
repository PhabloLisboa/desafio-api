package phablo.lisboa.desafioapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String cep;

	@NotNull
	private String logradouro;

	@NotNull
	private String bairro;

	@NotNull
	private String cidade;

	@NotNull
	private String UF;

	private String complemento;

	@OneToOne(mappedBy = "address")
	private Client client;

	public Address() {
	}

	public Address(String cep, String logradouro, String bairro, String cidade, String uF) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		UF = uF;
	}

	public Address(String cep, String logradouro, String bairro, String cidade, String uF, String complemento) {
		this(cep, logradouro, bairro, cidade, uF);
		this.setComplemento(complemento);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
