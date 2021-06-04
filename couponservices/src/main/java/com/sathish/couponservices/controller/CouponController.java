package com.sathish.couponservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathish.couponservices.CouponDTO;
import com.sathish.couponservices.model.Coupon;
import com.sathish.couponservices.repository.ICouponRepositiory;

@RestController()
public class CouponController {
	
	@Autowired
	ICouponRepositiory couponrepo;
	
	@RequestMapping("/coupons/save")
	@PostMapping
	public void saveCoupon (@RequestBody CouponDTO coupon) {
		
		Coupon newCoupon =new Coupon();
		newCoupon.setDescription(coupon.getDescription());
		newCoupon.setPrice(coupon.getPrice());
		newCoupon.setCode(coupon.getCoupon_code());
		couponrepo.save(newCoupon);
		
	}
	
	@RequestMapping("/coupons/{code}")
	@GetMapping
	public Coupon getCoupon (@PathVariable String code) {
		
	   return  couponrepo.findByCode(code);
		
	}

}
