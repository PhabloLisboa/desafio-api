package phablo.lisboa.desafioapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import phablo.lisboa.desafioapi.model.User;
import phablo.lisboa.desafioapi.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping
	public Iterable<User> getAll() {
		return service.findAll();
	}
}
