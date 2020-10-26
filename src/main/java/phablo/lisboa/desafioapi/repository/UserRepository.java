package phablo.lisboa.desafioapi.repository;

import org.springframework.data.repository.CrudRepository;

import phablo.lisboa.desafioapi.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
