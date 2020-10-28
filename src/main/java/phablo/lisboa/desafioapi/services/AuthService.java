package phablo.lisboa.desafioapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import phablo.lisboa.desafioapi.model.User;
import phablo.lisboa.desafioapi.repository.UserRepository;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepository;

	public User login(String username, String password) {
		User user = userRepository.findByUserName(username).get();

		if (user != null) {
			if (new BCryptPasswordEncoder().matches(password, user.getPassword())) {
				return user;
			}
			return null;
		} else {
			return null;
		}

	}
}
