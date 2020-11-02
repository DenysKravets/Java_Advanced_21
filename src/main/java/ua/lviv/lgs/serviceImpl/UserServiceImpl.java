package ua.lviv.lgs.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.domain.User;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void create(User user) {
		userDao.save(user);
	}
	
	public User read(Long id) {
		return userDao.findById(id).get();
	}
	
	public User readByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	public void update(User user) {
		userDao.save(user);
	}
	
	public void delete(User user) {
		userDao.delete(user);
	}
	
}
