package com.example.demo.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection="Companies")

public class Company {

	//GENERATE AUTO SEQUENCE FOR AVAILCOUPONS



	//GENERATE AUTO OBJECTID 

	@Id
	private String id;
	



	//COMPANY NAME
	private  String comname;

	//LIST OF CATEGORIES CLASS
	private  List<Categories> categories;

	
	/*
	 *GETTERS AND SETTERS
	 */

	public Company() {

	}


	public String getComname() {
		return comname;
	}


	public void setComname(String comname) {
		this.comname = comname;
	}


	public List<Categories> getCategories() {
		return categories;
	}


	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}


	public Company(String comname, List<Categories> categories) {
		super();
		this.comname = comname;
		this.categories = categories;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Company [id=" + id + ", comname=" + comname + ", categories=" + categories + "]";
	}


	







}
