package com.epam.time;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.couchbase.client.java.repository.annotation.Field;
import com.epam.time.model.Coupon;
import com.epam.time.repository.CouponRepository;
@RestController
public class CouponController {
	@Autowired
	private  CouponRepository couponRepository;
	
	
	 //-------------------Create a Coupon--------------------------------------------------------
	@PostMapping(value="/coupon",headers = "Accept=application/json" , produces = "application/json")
	private ResponseEntity<Coupon> saveCoupon(@RequestBody Coupon coupon) {	
		coupon.setId(UUID.randomUUID().toString());
		
		Coupon newCoupon= couponRepository.save(coupon);
		
		return new ResponseEntity<Coupon>(newCoupon, HttpStatus.CREATED);
	}
	
	
	   //-------------------Retrieve Coupon based on Id--------------------------------------------------------
	
	@GetMapping(value="/coupon/{id}", headers = "Accept=application/json" , produces = "application/json")
	public ResponseEntity<Coupon> getCoupon(@PathVariable("id") String id){
		 Coupon coupon= couponRepository.findOne(id);
		
		 if (coupon==null) {
	            System.out.println("Coupon with id " + id + " not found");
	            return new ResponseEntity<Coupon>(HttpStatus.NOT_FOUND);
	        }
		 
		 return new ResponseEntity<Coupon>(coupon, HttpStatus.OK);
	}


	 //------------------- Update a coupon --------------------------------------------------------
	
	@PutMapping(value="/coupon/{id}",headers = "Accept=application/json",produces = "application/json")
	public ResponseEntity<Coupon> updateCoupon(@PathVariable("id") String id,@RequestBody Coupon coupon){
	    Coupon newCoupon = new Coupon();
	    if(coupon.getId()!=null)
	    	newCoupon.setId(coupon.getId());
	    else
	    	newCoupon.setId(UUID.randomUUID().toString());
	    if(coupon.getCouponTitle()!=null)
		newCoupon.setCouponTitle(coupon.getCouponTitle());
	    if(coupon.getCouponDescription()!=null)
		newCoupon.setCouponDescription(coupon.getCouponDescription());
	    if(coupon.getValue()!=null)
		newCoupon.setValue(coupon.getValue());
	    if(coupon.getCreditType()!=null)
		newCoupon.setCreditType(coupon.getCreditType());
	    if(coupon.getAuthor()!=null)
		newCoupon.setAuthor(coupon.getAuthor());
	    if(coupon.getValidTill()!=null)
		newCoupon.setValidTill(coupon.getValidTill());
	    if(coupon.getCreatedDate()!=null)
		newCoupon.setCreatedDate(coupon.getCreatedDate());
	    if(coupon.getUpdatedDate()!=null)
		newCoupon.setUpdatedDate(coupon.getUpdatedDate());
		newCoupon=couponRepository.save(newCoupon);
		return new ResponseEntity<Coupon>(newCoupon, HttpStatus.OK);
	}
	
	//------------------- Delete a coupon --------------------------------------------------------
	
	@DeleteMapping("/coupon/{id}")
	public ResponseEntity<Coupon> deleteCoupon(@PathVariable("id") String id){
			couponRepository.delete(id);
		return new ResponseEntity<Coupon>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
}
