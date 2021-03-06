package ua.lviv.lgs.domain;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Periodical {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
	private Long price;
	
	@Lob
	private byte[] photo = null;
	
	@Transient
	private MultipartFile file;

	public Periodical() {}
	
	public Periodical(Long id, String name, String description, Long price, byte[] photo, MultipartFile file) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.photo = photo;
		this.file = file;
	}

	public Periodical(String name, String description, Long price, byte[] photo) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.photo = photo;
	}

	public Periodical(Long id, String name, String description, Long price, byte[] photo) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.photo = photo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Periodical [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ "]";
	}
	
}
