package ua.lviv.lgs.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.PeriodicalDao;
import ua.lviv.lgs.domain.Periodical;

@Service
public class PeriodicalServiceImpl {

	@Autowired
	private PeriodicalDao periodicalDao;
	
	@Transactional
	public void create(Periodical periodical) throws IOException {
		
		if(periodical.getPhoto() == null) {
			periodical.setPhoto(periodical.getFile().getBytes());
		}
		
		periodicalDao.save(periodical);
	}
	
	public Iterable<Periodical> readAll() {
		return periodicalDao.findAll();
	}
	
	public Periodical read(Long id) {
		return periodicalDao.findById(id).get();
	}
	
	public void update(Periodical periodical) {
		periodicalDao.save(periodical);
	}
	
	public void delete(Periodical periodical) {
		periodicalDao.delete(periodical);
	}
	
}
