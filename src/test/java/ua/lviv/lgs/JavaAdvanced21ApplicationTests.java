package ua.lviv.lgs;

import org.springframework.context.annotation.FilterType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.dao.PeriodicalDao;
import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Periodical;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.serviceImpl.BucketServiceImpl;
import ua.lviv.lgs.serviceImpl.PeriodicalServiceImpl;
import ua.lviv.lgs.serviceImpl.UserServiceImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
class JavaAdvanced21ApplicationTests {

	@Autowired
	UserDao userDao;
	
	@Autowired
	PeriodicalDao periodicalDao;
	
	@Autowired
	BucketDao bucketDao;
	
	private <T> List<T> map(Iterable<T> array) {
		List<T> list = new ArrayList<>();
		array.forEach(item -> {list.add(item);});
		return list;
	}
	
	//User
	@Test
	void testCreateUser() {
		
		List<User> users = map(userDao.findAll());
		assertThat(users, hasSize(0));
		
		User user = new User("1", "1", "1", UserRole.ADMIN);
		userDao.save(user);
		
		users = map(userDao.findAll());
		assertThat(users, hasSize(1));
		
		User dBUser = users.stream().findAny().get();
		
		assertTrue(user.getEmail().equals(dBUser.getEmail()));
		assertTrue(user.getUsername().equals(dBUser.getUsername()));
		assertTrue(user.getPassword().equals(dBUser.getPassword()));
		assertTrue(user.getRole().equals(dBUser.getRole()));
		
	}
	
	@Test
	void testReadUser() {
		
		List<User> users = map(userDao.findAll());
		assertThat(users, hasSize(0));
		
		User user = new User("1", "1", "1", UserRole.ADMIN);
		userDao.save(user);
		
		users = map(userDao.findAll());
		assertThat(users, hasSize(1));
		
		User dBUser = users.stream().findAny().get();
		
		assertTrue(user.getEmail().equals(dBUser.getEmail()));
		assertTrue(user.getUsername().equals(dBUser.getUsername()));
		assertTrue(user.getPassword().equals(dBUser.getPassword()));
		assertTrue(user.getRole().equals(dBUser.getRole()));
		
	}
	
	@Test
	void testDeleteUser() {
		
		List<User> users = map(userDao.findAll());
		assertThat(users, hasSize(0));
		
		User user = new User("1", "1", "1", UserRole.ADMIN);
		userDao.save(user);
		
		users = map(userDao.findAll());
		assertThat(users, hasSize(1));
		
		User dBUser = users.stream().findAny().get();
		
		assertTrue(user.getEmail().equals(dBUser.getEmail()));
		assertTrue(user.getUsername().equals(dBUser.getUsername()));
		assertTrue(user.getPassword().equals(dBUser.getPassword()));
		assertTrue(user.getRole().equals(dBUser.getRole()));
		
		userDao.delete(user);
		
		users = map(userDao.findAll());
		assertThat(users, hasSize(0));
		
	}
	
	@Test
	void testUpdateUser() {
		
		List<User> users = map(userDao.findAll());
		assertThat(users, hasSize(0));
		
		User user = new User("1", "1", "1", UserRole.ADMIN);
		userDao.save(user);
		
		users = map(userDao.findAll());
		assertThat(users, hasSize(1));
		
		User dBUser = users.stream().findAny().get();
		
		assertTrue(user.getEmail().equals(dBUser.getEmail()));
		assertTrue(user.getUsername().equals(dBUser.getUsername()));
		assertTrue(user.getPassword().equals(dBUser.getPassword()));
		assertTrue(user.getRole().equals(dBUser.getRole()));
		
		dBUser.setEmail("2");
		dBUser.setUsername("2");
		dBUser.setPassword("2");
		dBUser.setRole(UserRole.USER);
		userDao.save(dBUser);
		
		users = map(userDao.findAll());
		assertThat(users, hasSize(1));
		
		user = users.stream().findAny().get();
		
		assertTrue(dBUser.getEmail().equals(dBUser.getEmail()));
		assertTrue(dBUser.getUsername().equals(dBUser.getUsername()));
		assertTrue(dBUser.getPassword().equals(dBUser.getPassword()));
		assertTrue(dBUser.getRole().equals(dBUser.getRole()));
		
	}
	
	@Test
	void testFindUserByEmail() {
		
		List<User> users = map(userDao.findAll());
		assertThat(users, hasSize(0));
		
		User user = new User("1", "1", "1", UserRole.ADMIN);
		userDao.save(user);
		
		users = map(userDao.findAll());
		assertThat(users, hasSize(1));
		

		User dBUser = userDao.findByEmail("1");
		
		assertTrue(user.getEmail().equals(dBUser.getEmail()));
		assertTrue(user.getUsername().equals(dBUser.getUsername()));
		assertTrue(user.getPassword().equals(dBUser.getPassword()));
		assertTrue(user.getRole().equals(dBUser.getRole()));
		
	}
	
	@Test
	void testFindUserById() {
		
		List<User> users = map(userDao.findAll());
		assertThat(users, hasSize(0));
		
		User user = new User("1", "1", "1", UserRole.ADMIN);
		userDao.save(user);
		
		users = map(userDao.findAll());
		assertThat(users, hasSize(1));
		
		User dBUser = userDao.findById(users.stream().findAny().get().getId()).get();
		
		assertTrue(user.getEmail().equals(dBUser.getEmail()));
		assertTrue(user.getUsername().equals(dBUser.getUsername()));
		assertTrue(user.getPassword().equals(dBUser.getPassword()));
		assertTrue(user.getRole().equals(dBUser.getRole()));
		
	}

	//Periodical
	@Test
	void testCreatePeriodical() {
		
		List<Periodical> periodicals = map(periodicalDao.findAll());
		assertThat(periodicals, hasSize(0));
		
		byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		Periodical periodical = new Periodical("1", "1", (long) 1, bytes);
		periodicalDao.save(periodical);
		
		periodicals = map(periodicalDao.findAll());
		assertThat(periodicals, hasSize(1));
		
		Periodical dBPeriodical = periodicals.stream().findAny().get();
		
		assertTrue(periodical.getName().equals(dBPeriodical.getName()));
		assertTrue(periodical.getDescription().equals(dBPeriodical.getDescription()));
		assertTrue(periodical.getPrice().equals(dBPeriodical.getPrice()));
		assertTrue(periodical.getPhoto().equals(dBPeriodical.getPhoto()));
		
	}
	
	@Test
	void testReadPeriodical() {
		
		List<Periodical> periodicals = map(periodicalDao.findAll());
		assertThat(periodicals, hasSize(0));
		
		byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		Periodical periodical = new Periodical("1", "1", (long) 1, bytes);
		periodicalDao.save(periodical);
		
		periodicals = map(periodicalDao.findAll());
		assertThat(periodicals, hasSize(1));
		
		Periodical dBPeriodical = periodicals.stream().findAny().get();
		
		assertTrue(periodical.getName().equals(dBPeriodical.getName()));
		assertTrue(periodical.getDescription().equals(dBPeriodical.getDescription()));
		assertTrue(periodical.getPrice().equals(dBPeriodical.getPrice()));
		assertTrue(periodical.getPhoto().equals(dBPeriodical.getPhoto()));
		
	}
	
	@Test
	void testDeletePeriodical() {
		
		List<Periodical> periodicals = map(periodicalDao.findAll());
		assertThat(periodicals, hasSize(0));
		
		byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		Periodical periodical = new Periodical("1", "1", (long) 1, bytes);
		periodicalDao.save(periodical);
		
		periodicals = map(periodicalDao.findAll());
		assertThat(periodicals, hasSize(1));
		
		Periodical dBPeriodical = periodicals.stream().findAny().get();
		
		assertTrue(periodical.getName().equals(dBPeriodical.getName()));
		assertTrue(periodical.getDescription().equals(dBPeriodical.getDescription()));
		assertTrue(periodical.getPrice().equals(dBPeriodical.getPrice()));
		assertTrue(periodical.getPhoto().equals(dBPeriodical.getPhoto()));
		
		periodicalDao.delete(periodical);
		
		periodicals = map(periodicalDao.findAll());
		assertThat(periodicals, hasSize(0));
		
	}
	
	@Test
	void testUpdatePeriodical() {
		
		List<Periodical> periodicals = map(periodicalDao.findAll());
		assertThat(periodicals, hasSize(0));
		
		byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		Periodical periodical = new Periodical("1", "1", (long) 1, bytes);
		periodicalDao.save(periodical);
		
		periodicals = map(periodicalDao.findAll());
		assertThat(periodicals, hasSize(1));
		
		Periodical dBPeriodical = periodicals.stream().findAny().get();
		
		assertTrue(periodical.getName().equals(dBPeriodical.getName()));
		assertTrue(periodical.getDescription().equals(dBPeriodical.getDescription()));
		assertTrue(periodical.getPrice().equals(dBPeriodical.getPrice()));
		assertTrue(periodical.getPhoto().equals(dBPeriodical.getPhoto()));
		
		dBPeriodical.setName("2");
		dBPeriodical.setDescription("2");
		dBPeriodical.setPrice((long) 2);
		bytes = new byte[20];
		new Random().nextBytes(bytes);
		dBPeriodical.setPhoto(bytes);
		
		periodicals = map(periodicalDao.findAll());
		assertThat(periodicals, hasSize(1));
		
		periodical = periodicals.stream().findAny().get();
		
		assertTrue(dBPeriodical.getName().equals(periodical.getName()));
		assertTrue(dBPeriodical.getDescription().equals(periodical.getDescription()));
		assertTrue(dBPeriodical.getPrice().equals(periodical.getPrice()));
		assertTrue(dBPeriodical.getPhoto().equals(periodical.getPhoto()));
		
	}
	
	@Test
	void testFindPeriodicalById() {
		
		List<Periodical> periodicals = map(periodicalDao.findAll());
		assertThat(periodicals, hasSize(0));
		
		byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		Periodical periodical = new Periodical("1", "1", (long) 1, bytes);
		periodicalDao.save(periodical);
		
		periodicals = map(periodicalDao.findAll());
		assertThat(periodicals, hasSize(1));
		
		Periodical dBPeriodical = periodicalDao.findById(periodicals.stream().findAny().get().getId()).get();
		
		assertTrue(periodical.getName().equals(dBPeriodical.getName()));
		assertTrue(periodical.getDescription().equals(dBPeriodical.getDescription()));
		assertTrue(periodical.getPrice().equals(dBPeriodical.getPrice()));
		assertTrue(periodical.getPhoto().equals(dBPeriodical.getPhoto()));
		
	}
	
	//Bucket
	@Test
	void testCreateBucket() {
		
		List<Bucket> buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(0));
		
		byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		Periodical periodical = new Periodical("1", "1", (long) 1, bytes);
		periodicalDao.save(periodical);
		User user = new User("1", "1", "1", UserRole.ADMIN);
		userDao.save(user);
		Bucket bucket = new Bucket(user, periodical, new Date((long) 111111));
		
		bucketDao.save(bucket);
		
		buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(1));
		
		Bucket dBBucket = buckets.stream().findAny().get();
		
		assertTrue(bucket.getUser().equals(dBBucket.getUser()));
		assertTrue(bucket.getPeriodical().equals(dBBucket.getPeriodical()));
		assertTrue(bucket.getDate().equals(dBBucket.getDate()));
		
	}
	
	@Test
	void testReadBucket() {
		
		List<Bucket> buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(0));
		
		byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		Periodical periodical = new Periodical("1", "1", (long) 1, bytes);
		periodicalDao.save(periodical);
		User user = new User("1", "1", "1", UserRole.ADMIN);
		userDao.save(user);
		Bucket bucket = new Bucket(user, periodical, new Date((long) 111111));
		
		bucketDao.save(bucket);
		
		buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(1));
		
		Bucket dBBucket = buckets.stream().findAny().get();
		
		assertTrue(bucket.getUser().equals(dBBucket.getUser()));
		assertTrue(bucket.getPeriodical().equals(dBBucket.getPeriodical()));
		assertTrue(bucket.getDate().equals(dBBucket.getDate()));
		
	}
	
	@Test
	void testDeleteBucket() {
		
		List<Bucket> buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(0));
		
		byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		Periodical periodical = new Periodical("1", "1", (long) 1, bytes);
		periodicalDao.save(periodical);
		User user = new User("1", "1", "1", UserRole.ADMIN);
		userDao.save(user);
		Bucket bucket = new Bucket(user, periodical, new Date((long) 111111));
		
		bucketDao.save(bucket);
		
		buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(1));
		
		Bucket dBBucket = buckets.stream().findAny().get();
		
		assertTrue(bucket.getUser().equals(dBBucket.getUser()));
		assertTrue(bucket.getPeriodical().equals(dBBucket.getPeriodical()));
		assertTrue(bucket.getDate().equals(dBBucket.getDate()));
		
		bucketDao.delete(bucket);
		
		buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(0));
		
	}
	
	@Test
	void testUpdateBucket() {
		
		List<Bucket> buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(0));
		
		byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		Periodical periodical = new Periodical("1", "1", (long) 1, bytes);
		periodicalDao.save(periodical);
		User user = new User("1", "1", "1", UserRole.ADMIN);
		userDao.save(user);
		Bucket bucket = new Bucket(user, periodical, new Date((long) 111111));
		
		bucketDao.save(bucket);
		
		buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(1));
		
		Bucket dBBucket = buckets.stream().findAny().get();
		
		assertTrue(bucket.getUser().equals(dBBucket.getUser()));
		assertTrue(bucket.getPeriodical().equals(dBBucket.getPeriodical()));
		assertTrue(bucket.getDate().equals(dBBucket.getDate()));
		
		bytes = new byte[20];
		new Random().nextBytes(bytes);
		periodical = new Periodical("2", "2", (long) 2, bytes);
		periodicalDao.save(periodical);
		user = new User("2", "2", "2", UserRole.USER);
		userDao.save(user);
		dBBucket.setUser(user);
		dBBucket.setPeriodical(periodical);
		dBBucket.setDate(new Date((long) 222222));
		
		buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(1));
		
		bucket = buckets.stream().findAny().get();
		
		assertTrue(dBBucket.getUser().equals(bucket.getUser()));
		assertTrue(dBBucket.getPeriodical().equals(bucket.getPeriodical()));
		assertTrue(dBBucket.getDate().equals(bucket.getDate()));
		
	}
	
	@Test
	void testFindBucketById() {
		
		List<Bucket> buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(0));
		
		byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		Periodical periodical = new Periodical("1", "1", (long) 1, bytes);
		periodicalDao.save(periodical);
		User user = new User("1", "1", "1", UserRole.ADMIN);
		userDao.save(user);
		Bucket bucket = new Bucket(user, periodical, new Date((long) 111111));
		
		bucketDao.save(bucket);
		
		buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(1));
		
		Bucket dBBucket = bucketDao.findById(buckets.stream().findAny().get().getId()).get();
		
		assertTrue(bucket.getUser().equals(dBBucket.getUser()));
		assertTrue(bucket.getPeriodical().equals(dBBucket.getPeriodical()));
		assertTrue(bucket.getDate().equals(dBBucket.getDate()));
		
	}
	
	@Test
	void testFindBucketByUser() {
		
		List<Bucket> buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(0));
		
		byte[] bytes = new byte[20];
		new Random().nextBytes(bytes);
		Periodical periodical = new Periodical("1", "1", (long) 1, bytes);
		periodicalDao.save(periodical);
		User user = new User("1", "1", "1", UserRole.ADMIN);
		userDao.save(user);
		Bucket bucket = new Bucket(user, periodical, new Date((long) 111111));
		
		bucketDao.save(bucket);
		
		buckets = map(bucketDao.findAll());
		assertThat(buckets, hasSize(1));
		
		Bucket dBBucket = bucketDao.findByUser(userDao.findByEmail(user.getEmail())).findAny().get();
		
		assertTrue(bucket.getUser().equals(dBBucket.getUser()));
		assertTrue(bucket.getPeriodical().equals(dBBucket.getPeriodical()));
		assertTrue(bucket.getDate().equals(dBBucket.getDate()));
		
	}
	
}
