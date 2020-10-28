package phablo.lisboa.desafioapi.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phablo.lisboa.desafioapi.model.Address;
import phablo.lisboa.desafioapi.model.Client;
import phablo.lisboa.desafioapi.model.Email;
import phablo.lisboa.desafioapi.model.Phone;
import phablo.lisboa.desafioapi.model.PhoneType;
import phablo.lisboa.desafioapi.model.User;
import phablo.lisboa.desafioapi.repository.AddressRepository;
import phablo.lisboa.desafioapi.repository.ClientRepository;
import phablo.lisboa.desafioapi.repository.EmailRepository;
import phablo.lisboa.desafioapi.repository.PhoneRepository;
import phablo.lisboa.desafioapi.repository.PhoneTypeRepository;
import phablo.lisboa.desafioapi.repository.RoleRepository;
import phablo.lisboa.desafioapi.repository.UserRepository;
import phablo.lisboa.desafioapi.requests.ClientRequest;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmailRepository emailRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PhoneRepository PhoneRepository;

	@Autowired
	private PhoneTypeRepository phoneTypeRepository;

	@Autowired
	private RoleRepository roleRepository;

	public Iterable<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client findOne(Integer id) {
		return clientRepository.findById(id).get();
	}

	public Client create(ClientRequest request) {
		User user = new User(request.getUsername(), request.getPassword());
		Client client = new Client(request.getName(), request.getCpf().replace(".", "").replace("-", ""));
		Address address = request.getAddress();

		user.setRole(roleRepository.findById(2).get());

		address.setCep(address.getCep().replace(".", "").replace("-", ""));

		userRepository.save(user);
		addressRepository.save(address);

		client.setUser(user);
		client.setAddress(address);

		clientRepository.save(client);

		request.getEmails().stream().forEach(email -> emailRepository.save(new Email(email, client)));

		for (HashMap<String, String> phone : request.getPhones()) {
			Object number = phone.get("number").replace("(", "").replace("-", "").replace(")", "").replace(" ", "");
			PhoneType type = phoneTypeRepository.findById(Integer.valueOf((String) phone.get("type"))).get();
			PhoneRepository.save(new Phone((String) number, client, type));
		}

		return client;
	}

	public Client update(Integer id, ClientRequest request) {
		Client client = clientRepository.findById(id).get();
		User user = userRepository.findById(client.getUser().getId()).get();
		Address address = addressRepository.findById(client.getAddress().getId()).get();

		user.setUsername(request.getUsername());
		address.update(request.getAddress().getCep().replace(".", "").replace("-", ""),
				request.getAddress().getLogradouro(), request.getAddress().getBairro(),
				request.getAddress().getCidade(), request.getAddress().getUF(), request.getAddress().getComplemento());

		userRepository.save(user);
		addressRepository.save(address);

		client.setName(request.getName());
		client.setCpf(request.getCpf().replace(".", "").replace("-", ""));
		clientRepository.save(client);

		return client;

	}

	public boolean delete(Integer id) {
		if (clientRepository.findById(id).get() != null) {
			clientRepository.deleteById(id);
			return true;
		}

		return false;
	}

}
