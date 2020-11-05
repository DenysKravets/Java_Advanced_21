package ua.lviv.lgs.dto;

public class PeriodicalDto {

	public Long id;
	public String name;
	public String description;
	public Long price;
	public String photo;
	
	
	
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



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	@Override
	public String toString() {
		return "PeriodicalDto [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", photo=" + photo + "]";
	}
}
