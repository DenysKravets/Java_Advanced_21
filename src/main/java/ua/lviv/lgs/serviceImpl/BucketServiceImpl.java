package ua.lviv.lgs.serviceImpl;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.User;

@Service
public class BucketServiceImpl {

	@Autowired
	private BucketDao bucketDao;
	
	@Transactional
	public void create(Bucket bucket) {
		bucketDao.save(bucket);
	}
	
	public Bucket read(Long id) {
		return bucketDao.findById(id).get();
	}
	
	public Stream<Bucket> readByUser(User user) {
		return bucketDao.findByUser(user);
	}
	
	public void update(Bucket bucket) {
		bucketDao.save(bucket);
	}
	
	@Transactional
	public void delete(Bucket bucket) {
		bucketDao.delete(bucket);
	}
	
}
