package com.example.demo.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;


@Document(collection="coupon_details")
@CompoundIndexes({
@CompoundIndex(name = "code_idx", def = "{'code' : 1}", unique = true, background = true)})
public class Coupon {


	@Transient
	public static final String SEQUENCE_NAME = "coupon_sequence";

   
	@Id ObjectId databaseid;

	//available coupons automatic generated
	private int  availcoupons;

	 @Field(name = "code")
	private String code; 
	 
	private  String discount; 
	
	private int amount;
	
	//local date&time printed 

	



	ZoneId zoneId = ZoneId.of("America/Chicago");
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss",timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private LocalDateTime createdDate = LocalDateTime.now(zoneId);

    //coupon will be expired after 40seconds days
	
	@LastModifiedDate
	@Indexed(name="createdAtIndex",expireAfter="40s")
	private LocalDateTime lastModifiedDate= LocalDateTime.now(zoneId);


	public ObjectId getDatabaseid() {
		return databaseid;
	}

	public void setDatabaseid(ObjectId databaseid) {
		this.databaseid = databaseid;
	}



	public int getAvailcoupons() {
		return availcoupons;
	}

	public void setAvailcoupons(int availcoupons) {
		this.availcoupons = availcoupons;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ZoneId getZoneId() {
		return zoneId;
	}

	public void setZoneId(ZoneId zoneId) {
		this.zoneId = zoneId;
	}




	
	




	public Coupon(String code, String discount, int amount, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
		super();
		this.code = code;
		this.discount = discount;
		this.amount = amount;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}


	public Coupon() {

	}

	





}

