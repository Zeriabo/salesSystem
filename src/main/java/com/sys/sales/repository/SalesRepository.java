package com.sys.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sys.sales.model.Sale;

public interface SalesRepository extends JpaRepository<Sale,Long> {

}
