package com.example.ProductDemo;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Product {
	@Id
	private int id;
	private String name;
	private double price;
	public Product() {
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
}
