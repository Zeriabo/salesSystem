package com.sys.sales.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sys.sales.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	

}
