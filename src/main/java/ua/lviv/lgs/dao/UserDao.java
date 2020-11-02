package ua.lviv.lgs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

	public User findByEmail(String email);
	
}
