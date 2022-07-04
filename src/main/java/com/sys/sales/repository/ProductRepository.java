package com.sys.sales.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sys.sales.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	

}
