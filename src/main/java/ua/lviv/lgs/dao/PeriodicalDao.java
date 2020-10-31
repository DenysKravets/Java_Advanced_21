package ua.lviv.lgs.dao;

import org.springframework.data.repository.CrudRepository;

import ua.lviv.lgs.domain.Periodical;

public interface PeriodicalDao extends CrudRepository<Periodical, Long> {

}
