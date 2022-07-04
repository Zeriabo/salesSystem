package com.sys.sales.model;

public class ProductsQuantities {

	private Product product;

	private int quantity;

	public ProductsQuantities() {
		this.quantity = 0;
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
