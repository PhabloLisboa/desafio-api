package phablo.lisboa.desafioapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import phablo.lisboa.desafioapi.model.User;
import phablo.lisboa.desafioapi.requests.LoginRequest;
import phablo.lisboa.desafioapi.services.AuthService;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class AuthController {
	@Autowired
	private AuthService service;

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity create(@RequestBody LoginRequest request) {
		try {
			User logged = service.login(request.getUsername(), request.getPassword());

			if (logged == null)
				return ResponseEntity.status(400)
						.body(new Gson().toJson("{\"message\": \"Usuário ou Senha Incorreto\"}"));

			return ResponseEntity.ok(logged);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(new Gson().toJson("{\"message\": \"Usuário ou Senha Incorreto\"}"));
		}
	}

}
