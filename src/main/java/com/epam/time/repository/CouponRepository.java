package com.epam.time.repository;

import java.io.Serializable;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

import com.epam.time.model.Coupon;

public interface CouponRepository extends CouchbaseRepository<Coupon, String> {

}
