package com.sys.sales.model;






import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;



@Table(name="Sale") 
@Entity
@DynamicUpdate
public class Sale {
	
	

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   
	    @OneToOne
	    @JoinColumn(name = "client_id")
	    private Client client;
	    
	    @OneToOne
	    @JoinColumn(name = "seller_id")
	    private Seller seller;
	   
	    @OneToOne
	    @JoinColumn(name = "product_id")
	    private Product product;
	    
	    @Column(name="quantity",nullable = false)
	    private int quantity=0;
	    
	    @Column(name="totalPrice",nullable = false)
	    private long totalPrice=0;
	
	    @Column(name="creationDate",nullable = false)
	    private String creationDate;
	    
	    public Long getId() {
	    	return this.id;
	    }
	    public void setId(Long id) {
	    	this.id=id;
	    }
	    public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	    public Client getClient() {
	    	return this.client;
	    }
	    public void setClient(Client client) {
	    	this.client=client;
	    }
	    
	    public Seller getSeller() {
	    	return this.seller;
	    }
	    public void setSeller(Seller seller) {
	    	this.seller=seller;
	    }
	    
	    
	    public void setTotalPrice(long totalPrice) {
	    	this.totalPrice=totalPrice;
	    }
	    
	    public long getTotalPrice() {
	    	return this.totalPrice;
	    }
	    public void setCreationDate(String creationDate) {
	    	this.creationDate=creationDate;
	    }
	    
	    public String getCreationDate() {
	    	return this.creationDate;
	    }
	    public void setProduct( Product product) {
	    	this.product=product;
	    }
	    
	    public Product getProduct() {
	    	return this.product;
	    }
	    public void calculateTotalPrice() {
	    	 setTotalPrice(this.quantity*this.product.getPrice());
	    }
	
}
