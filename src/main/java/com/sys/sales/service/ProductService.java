package com.sys.sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.sys.sales.model.Product;
import com.sys.sales.repository.ProductRepository;
import java.sql.ResultSet;

@Service
public class ProductService implements IProductService {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unused")
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository)
	{
		this.productRepository=productRepository;
	}
	
	@Override
	public  Product getById(Long id) {
		 

		Product product = (Product) jdbcTemplate.query("select * from product " + "where  id=?", new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet resultSet, int i) throws SQLException {
				Product product = new Product();

				product.setId(resultSet.getLong("id"));
			    product.setCategory(resultSet.getString("category"));
			    product.setCreationDate(resultSet.getString("creation_date"));
			    product.setDescription(resultSet.getString("description"));
			    product.setName(resultSet.getString("name"));
			    product.setPrice(resultSet.getLong("price"));
			
				return product;
			}

		}, id);
		
		
		 
return product;
	}



}
