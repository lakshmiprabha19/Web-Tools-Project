package com.neu.myapplication.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="car")
public class Car {
	@Id
	@GeneratedValue
	@Column(name = "carId", unique = true, nullable = false)
	private int carId;
	
	@Column(name = "carName")
	private String carName;
	
	@Column(name = "carBrand")
	private String carBrand;
	
	@Column(name = "carModel")
	private String carModel;
	
	@Column(name = "productionYear")
	private int productionYear;
	
	@Column(name = "color")
	private String color;
	
	@Transient
	@Column(name="carPhoto")
	private MultipartFile photo;
	
	@Column(name="photoname")
	private String photoName;

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Car(){
		
	}
	
	public Car(String carName, String carBrand, String carModel, String color, int productionYear, String photoName){
		this.carName = carName;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.color = color;
		this.productionYear = productionYear;	
		this.photoName = photoName;
	}
	
}
