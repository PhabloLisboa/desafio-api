package phablo.lisboa.desafioapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import phablo.lisboa.desafioapi.model.Client;
import phablo.lisboa.desafioapi.requests.ClientRequest;
import phablo.lisboa.desafioapi.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping
	public Iterable<Client> getAll() {
		return service.findAll();
	}

	@PostMapping
	public ResponseEntity create(@RequestBody ClientRequest request) {
		try {
			Client created = service.create(request);
			return ResponseEntity.ok(created);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity update(@RequestParam String id, @RequestBody ClientRequest request) {
		try {
			Client updated = service.update(Integer.valueOf(id), request);
			return ResponseEntity.ok(updated);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	@DeleteMapping
	public ResponseEntity delete(@RequestParam String id) {
		System.out.println(id);
		boolean deleted = service.delete(Integer.valueOf(id));

		if (deleted) {
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.status(404).body("Não encontrado");
		}

	}
}
