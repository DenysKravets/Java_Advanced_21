package ua.lviv.lgs.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.domain.Bucket;

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
	
	public void update(Bucket bucket) {
		bucketDao.save(bucket);
	}
	
	public void delete(Bucket bucket) {
		bucketDao.delete(bucket);
	}
	
}
