package ua.lviv.lgs.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bucket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Periodical periodical;
	
	private Date date;

	public Bucket() {}

	public Bucket(User user, Periodical periodical, Date date) {
		this.user = user;
		this.periodical = periodical;
		this.date = date;
	}

	public Bucket(Long id, User user, Periodical periodical, Date date) {
		this.id = id;
		this.user = user;
		this.periodical = periodical;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Periodical getPeriodical() {
		return periodical;
	}

	public void setPeriodical(Periodical periodical) {
		this.periodical = periodical;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user=" + user + ", periodical=" + periodical + ", date=" + date + "]";
	}

	

}
