package com.sys.sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


import com.sys.sales.model.Client;
import com.sys.sales.repository.ClientRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
@Service
public class ClientService implements IClientService {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unused")
	private final ClientRepository clientRepository;
	
	public ClientService(ClientRepository clientRepository)
	{
		this.clientRepository=clientRepository;
	}
	
	@Override
	public  Client getById(Long id) {
		 

		Client client = (Client) jdbcTemplate.query("select * from client " + "where  id=?", new RowMapper<Client>() {
			@Override
			public Client mapRow(ResultSet resultSet, int i) throws SQLException {
				Client client = new Client();

				client.setId(resultSet.getLong("id"));
				client.setLastName(resultSet.getString("last_name"));
				client.setMobile(resultSet.getString("mobile"));
				client.setName(resultSet.getString("name"));
			
			
				return client;
			}

		}, id);
		
		
		 
return client;
	}



}
