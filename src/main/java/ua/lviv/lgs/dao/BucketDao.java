package ua.lviv.lgs.dao;

import org.springframework.data.repository.CrudRepository;

import ua.lviv.lgs.domain.Bucket;

public interface BucketDao extends CrudRepository<Bucket, Long> {

}
