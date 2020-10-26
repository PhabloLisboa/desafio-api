package phablo.lisboa.desafioapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import phablo.lisboa.desafioapi.model.Client;
import phablo.lisboa.desafioapi.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
//	{
//		"nome" : min3-max100,
//		"senha": 126381,
//		"email": fsdghjaskda
//		"cpf": 1231221
//		"endereco": {
//			"cep": asdhasd,
//			"logradouro": 128631,
//			"complemento": hasdkasd,
//			"bairro": askjdas,
//			"cidade": asdjggasd,
//			"uf": "GO",
//		},
//		"telefones": [
//          {
//        	  "number": 1231231
//        	  "type": asdhaskd
//          }           
//		]
//	}

	@Autowired
	private ClientService service;

	@GetMapping
	public Iterable<Client> getAll() {
		return service.findAll();
	}

//	@PostMapping
//	public ResponseEntity<Client> create(@RequestBody client){
//		
//	}
}
