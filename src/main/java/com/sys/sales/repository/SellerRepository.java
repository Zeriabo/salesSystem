package com.sys.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sys.sales.model.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long> {

}
