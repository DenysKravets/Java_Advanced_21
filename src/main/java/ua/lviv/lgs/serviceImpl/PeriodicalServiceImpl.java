package ua.lviv.lgs.serviceImpl;

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
	public void create(Periodical periodical) {
		periodicalDao.save(periodical);
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
