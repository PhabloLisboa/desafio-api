package phablo.lisboa.desafioapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phablo.lisboa.desafioapi.model.User;
import phablo.lisboa.desafioapi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

}
