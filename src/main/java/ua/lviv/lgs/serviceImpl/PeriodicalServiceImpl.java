package ua.lviv.lgs.serviceImpl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.PeriodicalDao;
import ua.lviv.lgs.domain.Periodical;

@Service
public class PeriodicalServiceImpl {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private PeriodicalDao periodicalDao;
	
	@Transactional
	public void create(Periodical periodical) throws IOException {
		
		if(periodical.getPhoto() == null) {
			periodical.setPhoto(periodical.getFile().getBytes());
		}
		
		logger.info("created a new periodical: " + periodical);
		periodicalDao.save(periodical);
	}
	
	public Iterable<Periodical> readAll() {
		logger.info("read all periodicals: ");
		return periodicalDao.findAll();
	}
	
	public Periodical read(Long id) {
		logger.info("read periodical with id: " + id);
		return periodicalDao.findById(id).get();
	}
	
	public void update(Periodical periodical) {
		logger.info("updated periodical: " + periodical);
		periodicalDao.save(periodical);
	}
	
	public void delete(Periodical periodical) {
		logger.info("deleted periodical: " + periodical);
		periodicalDao.delete(periodical);
	}
	
}
