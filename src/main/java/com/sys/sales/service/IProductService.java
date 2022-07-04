package com.sys.sales.service;

import java.util.Optional;

import org.springframework.ui.Model;

import com.sys.sales.model.Product;

public interface IProductService {
	
	Product getById(Long id);


}
