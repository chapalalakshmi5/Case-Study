package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.component.Validations;
import com.example.demo.entity.Coupon;
import com.example.demo.entity.Customer;
import com.example.demo.exceptions.CouponNotExistsException;
import com.example.demo.exceptions.CouponSystemException;
import com.example.demo.repository.CouponRepository;
import com.example.demo.repository.CustomerRepository;

public class CustomerService implements Validations{
	
	@Autowired 
	private CustomerRepository customerRepository;
	@Autowired
	private CouponRepository couponRepository;
	
	
	public void purchaseCoupon(Customer customer,String code)throws CouponSystemException
	{
		this.isCustomerHasCoupon(customer.getId(),code,couponRepository);
		Coupon coupon = couponRepository.findById(code)
                .orElseThrow(() -> new CouponNotExistsException("This coupon doesn't exist."));
		
		 if (coupon.getAmount()>0) {

             coupon.setAmount(coupon.getAmount() - 1);
             couponRepository.save(coupon);

             customer.purchaseCoupon(coupon);
             customerRepository.save(customer);

		
	}

}
}
