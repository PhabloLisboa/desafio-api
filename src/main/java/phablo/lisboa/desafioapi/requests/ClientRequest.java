package phablo.lisboa.desafioapi.requests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import phablo.lisboa.desafioapi.model.Address;

public class ClientRequest {

	private String name;
	private String username;
	private String password;
	private String cpf;
	private List<String> emails = new ArrayList<>();
	private Address address;
	private List<HashMap<String, String>> phones = new ArrayList<HashMap<String, String>>();

	public ClientRequest(String name, String username, String password, String cpf, List<String> emails,
			Address address, List<HashMap<String, String>> phones) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.cpf = cpf;
		this.emails = emails;
		this.address = address;
		this.phones = phones;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<HashMap<String, String>> getPhones() {
		return phones;
	}

	public void setPhones(List<HashMap<String, String>> phones) {
		this.phones = phones;
	}

}
