package com.embraces.hive.util;

import com.fasterxml.jackson.core.type.TypeReference;



public abstract class JsonUtils {

	public static String toJson(Object jsonObject,  String... filterNames) {
			try {
				return PojoMapper.toJson(jsonObject, filterNames);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}

	public static <T> T toObject(String text, Class<T> type) {
		try {
			return PojoMapper.fromJson(text, type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//可转换List等，调用方式：toObject(str,new TypeReference<List<QueryDTO>>(){});
	public static <T> T toObject(String text, TypeReference<T> type) {
		try {
			return PojoMapper.fromJson(text, type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
