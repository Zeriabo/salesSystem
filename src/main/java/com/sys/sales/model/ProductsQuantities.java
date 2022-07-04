package com.sys.sales.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


public class ProductsQuantities {

	    private Product product;
	   
	    private int quantity;
	    
public ProductsQuantities()
{
	this.quantity=0;
}

public int getQuantity() {
    return this.quantity;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}
	
		/**
		 * @return the product
		 */
		public Product getProduct() {
			return product;
		}
		public double getAmount() {
	        return this.product.getPrice() * this.quantity;
	    }
		/**
		 * @param product the product to set
		 */
		public void setProduct(Product product) {
			this.product = product;
		}
	
	
}
