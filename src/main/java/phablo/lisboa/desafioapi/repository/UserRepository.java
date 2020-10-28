package phablo.lisboa.desafioapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import phablo.lisboa.desafioapi.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	@Query(value = "select u.* from user u where u.username = :username", nativeQuery = true)
	Optional<User> findByUserName(@Param("username") String username);
}
