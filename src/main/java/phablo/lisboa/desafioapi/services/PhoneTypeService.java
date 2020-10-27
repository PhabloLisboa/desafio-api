package phablo.lisboa.desafioapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phablo.lisboa.desafioapi.repository.PhoneTypeRepository;

@Service
public class PhoneTypeService {

	@Autowired
	private PhoneTypeRepository phoneTypeRepository;

}
