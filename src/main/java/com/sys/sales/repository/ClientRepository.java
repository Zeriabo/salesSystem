package com.sys.sales.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.sys.sales.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	

}
