package com.sys.sales.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<Product>  {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Product product = new Product();
			product.setId(rs.getLong("id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setCategory(rs.getString("category"));
			product.setCreationDate(rs.getString("creation_date"));
		
			
			return product;
		}
	

}
