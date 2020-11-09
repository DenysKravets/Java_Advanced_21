package ua.lviv.lgs.serviceImpl;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.User;

@Service
public class BucketServiceImpl {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private BucketDao bucketDao;
	
	@Transactional
	public void create(Bucket bucket) {
		logger.info("created a new bucket: " + bucket);
		bucketDao.save(bucket);
	}
	
	public Bucket read(Long id) {
		logger.info("read bucket with id: " + id);
		return bucketDao.findById(id).get();
	}
	
	public Stream<Bucket> readByUser(User user) {
		logger.info("read buckets with user: " + user);
		return bucketDao.findByUser(user);
	}
	
	public void update(Bucket bucket) {
		logger.info("updated bucket: " + bucket);
		bucketDao.save(bucket);
	}
	
	@Transactional
	public void delete(Bucket bucket) {
		logger.info("deleted bucket: " + bucket);
		bucketDao.delete(bucket);
	}
	
}
