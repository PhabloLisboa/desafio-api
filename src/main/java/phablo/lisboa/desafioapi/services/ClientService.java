package phablo.lisboa.desafioapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phablo.lisboa.desafioapi.model.Client;
import phablo.lisboa.desafioapi.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public Iterable<Client> findAll() {
		return clientRepository.findAll();
	}
}
