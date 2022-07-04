package com.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sys.sales.model.Sale;

import com.sys.sales.repository.ClientRepository;


import com.sys.sales.repository.SalesRepository;
import com.sys.sales.repository.SellerRepository;
import com.sys.sales.service.ClientService;
import com.sys.sales.service.ProductService;
import com.sys.sales.service.SellerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/sale")
public class SalesController {

	@Autowired
	SalesRepository salesRepository;

	ClientRepository clientRepository;
	SellerRepository sellerRepository;
	
	ClientService clientService = new ClientService(clientRepository);
	SellerService sellerService= new SellerService(sellerRepository);
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	public NamedParameterJdbcTemplate template;
	Map<String, Object> map = new HashMap<>();
	
	private static final Logger LOGGER = LogManager.getLogger(SalesController.class);
	 
	@GetMapping("/sales")
	public List<Sale>  Sales() {
		
		  LOGGER.info("Getting sales operations");
	       
		return salesRepository.findAll();

	
	}	
	@PostMapping("/create")
	public ModelAndView createSale(Sale sale) {
		
		  LOGGER.debug("Creating sale");
	       
		ModelAndView mv = new ModelAndView("sales");
		sale.calculateTotalPrice();
		try {
			salesRepository.save(sale);
		}catch(Exception e)
		{
			LOGGER.error(e.getMessage());
		}
		
		mv.addObject("sale", sale);
		return mv;
	}
	
	
	@PostMapping("/edit")
	public ModelAndView editSale(@RequestParam(required = true) long id,@RequestParam(required = false) int quantity,
		
			@RequestParam(required = false) Long price) {
		
		ModelAndView mv = new ModelAndView("sales");
		Optional<Sale> saleToUpdate=salesRepository.findById(id);
		
		Sale updated = saleToUpdate.get();
		if(quantity!=0)
		{
			LOGGER.debug("Updating quantity of sale: "+updated.getId()+" To"+quantity+" of product "+updated.getProduct().getName());
			
			updated.setQuantity(quantity);
		}else {
			LOGGER.info("quantity not set");
		}
	if(price!=0)
	{
		LOGGER.debug("Updating price of sale: "+updated.getId()+" To"+price);
		updated.setTotalPrice(price);
	}else {
		LOGGER.debug("price not set of "+updated.getId());
	}
		

      salesRepository.save(updated);
		mv.addObject("sale", updated);
		return mv;
	}
		
}
