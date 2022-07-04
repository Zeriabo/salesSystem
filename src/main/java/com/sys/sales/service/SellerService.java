package com.sys.sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.sys.sales.model.Seller;
import com.sys.sales.repository.SellerRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
@Service
public class SellerService implements ISellerService {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unused")
	private final SellerRepository sellerRepository;
	
	public SellerService(SellerRepository sellerRepository)
	{
		this.sellerRepository=sellerRepository;
	}
	
	@Override
	public  Seller getById(Long id) {
		 

		Seller seller = (Seller) jdbcTemplate.query("select * from seller " + "where  id=?", new RowMapper<Seller>() {
			@Override
			public Seller mapRow(ResultSet resultSet, int i) throws SQLException {
				Seller seller = new Seller();

				seller.setId(resultSet.getLong("id"));
				seller.setLastName(resultSet.getString("last_name"));
				seller.setMobile(resultSet.getString("mobile"));
				seller.setName(resultSet.getString("name"));
			
			
				return seller;
			}

		}, id);
		
		
		 
return seller;
	}



}
