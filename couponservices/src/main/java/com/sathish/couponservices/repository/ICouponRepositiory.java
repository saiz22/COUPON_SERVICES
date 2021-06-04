package com.sathish.couponservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathish.couponservices.model.Coupon;

public interface ICouponRepositiory extends JpaRepository<Coupon, Integer>{

	Coupon findByCode(String code);
	

}
