package ua.lviv.lgs.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.domain.User;

@Service
public class UserServiceImpl {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void create(User user) {
		logger.info("created a new user: " + user);
		userDao.save(user);
	}
	
	public User read(Long id) {
		logger.info("read periodical with id: " + id);
		return userDao.findById(id).get();
	}
	
	public User readByEmail(String email) {
		logger.info("read periodical by email:: " + email);
		return userDao.findByEmail(email);
	}
	
	public void update(User user) {
		logger.info("updated user: " + user);
		userDao.save(user);
	}
	
	public void delete(User user) {
		logger.info("deleted user: " + user);
		userDao.delete(user);
	}
	
}
