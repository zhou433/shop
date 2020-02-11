package com.shop.utils;

import java.util.UUID;

public class UUIDDemo {
	public static void main(String[] args) {
		String uuidString = UUID.randomUUID().toString();
    	System.out.println("uuid:"+uuidString);
    	
    	String replace = uuidString.replace("-","");
    	
    	System.out.println(replace);
	}
}
