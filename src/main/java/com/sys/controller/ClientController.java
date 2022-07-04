package com.sys.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sys.sales.model.Client;
import com.sys.sales.repository.ClientRepository;


@CrossOrigin("*")
@RestController
public class ClientController {

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	

	@Autowired
	public NamedParameterJdbcTemplate template;
	Map<String, Object> map = new HashMap<>();
	
	@GetMapping("/clients")
	public List<Client> Clients() {
		
		
		List<Client> list = new ArrayList<>();

			list = jdbcTemplate.query("select * from client", new RowMapper<Client>() {
				@Override
				public Client mapRow(ResultSet resultSet, int i) throws SQLException {
					Client client = new Client();
					client.setName(resultSet.getString("name"));
					client.setId(resultSet.getLong("id"));
					client.setLastName(resultSet.getString("last_name"));
					client.setMobile(resultSet.getString("mobile"));

					return client;
				}
			});
			return list;
		
	
	}
	@PostMapping("/createclient")
	public void CreateClient(@RequestParam(required = false) String name,
			@RequestParam(required = false) String lastname,
			@RequestParam(required = false) String mobile
			) {
		
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println(formatter.format(date));
		Client client = new Client();
		client.setLastName(lastname);
		client.setMobile(mobile);
		client.setName(name);
		
		
		String query = "insert into client(name, last_name ,mobile) values(:name,:lastname,:mobile)";
		map.put("lastname", client.getLastName());
		map.put("mobile", client.getMobile());
		map.put("name", client.getName());

		
		template.update(query, map);

		
	
	}	
	@PostMapping("/updateclient")
	public void UpdateClient(@RequestParam(required = false) Long id,
			@RequestParam(required = false) String mobile) {
		
		Date date = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println(formatter.format(date));

		//clientRepository.updateClientsMobile(mobile,id);
		


		
	
	}	
}
