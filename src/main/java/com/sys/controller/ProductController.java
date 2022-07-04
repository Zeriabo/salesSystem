package com.sys.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sys.sales.model.Product;
import com.sys.sales.model.ProductRowMapper;
import com.sys.sales.repository.ProductRepository;
import com.sys.sales.service.ProductService;

@CrossOrigin("*")
@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	ProductService productService = new ProductService(productRepository);
	
	
	@Autowired
	public NamedParameterJdbcTemplate template;
	Map<String, Object> map = new HashMap<>();
	
	@GetMapping("/products")
	public List<Product> Products() {
		
		
		List<Product> list = new ArrayList<>();

			list = jdbcTemplate.query("select * from Product", new RowMapper<Product>() {
				@Override
				public Product mapRow(ResultSet resultSet, int i) throws SQLException {
					Product product = new Product();
					product.setName(resultSet.getString("name"));
					product.setId(resultSet.getLong("id"));
					product.setDescription(resultSet.getString("description"));
					product.setCategory(resultSet.getString("category"));
					product.setCreationDate(resultSet.getString("creation_date"));
				//	Exercise exercise = exerciseRepository.findById(resultSet.getInt("ID")).get();
			

					return product;
				}
			});
			return list;
		
	
	}	
			
	@PostMapping("/createproduct")
	public void CreateProduct(@RequestParam(required = false) String name,
			@RequestParam(required = false) String description,
			@RequestParam(required = false) String category,
			@RequestParam(required = false) Long price) {
		
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println(formatter.format(date));
		Product product = new Product();
		product.setCategory(category);
		product.setCreationDate(date.toString());
		product.setDescription(description);
		product.setName(name);
		product.setPrice(price);
		
		
		String query = "insert into product(category, creation_date ,description,name,price) values(:category,:creation_date,:description,:name,:price)";
		map.put("category", product.getCategory());
		map.put("creation_date", product.getCreationDate());
		map.put("description", product.getDescription());
		map.put("name", product.getName());
		map.put("price", product.getPrice());
		
		template.update(query, map);

		
	
	}		
			
	@GetMapping("/updateproduct")
	public String UpdateProducts(
			@RequestParam(required = true) long id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String description,
			@RequestParam(required = false) String category,
			@RequestParam(required = false) Long price,Model model) {
		
		Product product = productService.getById(id);
	
	String update="";
	
	if(product != null)
	{
   
      if(price!=null) {
	   product.setPrice(price);
      }if(category!=null) {
    	  product.setCategory(category);
      }if(description!=null) {
    	  product.setDescription(description);
      }if(name!=null) {
    	  product.setName(name);
      }
       
      productRepository.save(product);
      update="updated";
	}
	 update="No product with this id";
		
	return update;
	}			
			

}
