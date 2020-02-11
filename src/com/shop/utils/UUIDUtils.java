package com.shop.utils;

import java.util.UUID;
/**
 * @version 1.0
 * @author zhou
 *
 */
public class UUIDUtils {
	/**
	 * 获取带有横线的UUID
	 * @return
	 */
	public static String getUUID()
	{
		return UUID.randomUUID().toString();
	}
	/**
	 * 获取不带有横线的uuid
	 * @return
	 */
	public static String getUUID2() {
		return UUID.randomUUID().toString().replace("-","");
	}

}
