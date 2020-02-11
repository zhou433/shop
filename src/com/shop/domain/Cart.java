package com.shop.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<String,CartItem> cartItem = new HashMap<String,CartItem>();

	public Map<String, CartItem> getCartItems() {
		return cartItem;
	}

	public void setCartItem(Map<String, CartItem> cartItem) {
		this.cartItem = cartItem;
	}
}
