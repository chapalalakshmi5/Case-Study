package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Company;
import com.example.demo.entity.Coupon;
import com.example.demo.entity.Customer;



@Repository
public interface CouponRepository extends MongoRepository<Coupon,String> {

	void deleteByCode(String code);

	Optional<Coupon> findByCode(String code);

	Optional<Coupon> findCompanyCoupon(String id, String code);

	Optional<Coupon> findCustomerCoupon(String id, String code);

	


}
