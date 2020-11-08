package ua.lviv.lgs.dao;

import java.util.stream.Stream;

import org.springframework.data.repository.CrudRepository;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.User;

public interface BucketDao extends CrudRepository<Bucket, Long> {

	public Stream<Bucket> findByUser(User user);
	
}
