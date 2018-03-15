package com.embraces.hive.util;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * deserialize a json string to an object serialize an object to a json string
 * 
 * @author bingo
 */
public class PojoMapper {
	private static final String FILTER_NAME = "_Filter_Name";
	private static final String JSON_DATE_FROMATE = "yyyy-MM-dd HH:mm:ss";

	/**
	 * deserializea a json string to an object
	 * 
	 * @param <T>
	 * @param jsonAsString
	 * @param pojoClass
	 * @return
	 * @throws Exception
	 */
	public static <T> T fromJson(String jsonAsString, Class<T> pojoClass)
			throws Exception {
		return (T) getObjectMapper().readValue(jsonAsString, pojoClass);
	}

	/**
	 * deserializea a json string to an object
	 * 
	 * @param <T>
	 * @param jsonAsString
	 * @param pojoClass
	 * @return
	 * @throws Exception
	 */
	public static <T> T fromJson(String jsonAsString, TypeReference<T> type)
			throws Exception {
		return (T) getObjectMapper().readValue(jsonAsString, type);
	}

	/**
	 * serializea an object to a json string
	 * 
	 * @param pojo
	 * @param prettyPrint
	 *            if true,enabling pretty-printing using the default pretty
	 *            printer
	 * @return
	 * @throws Exception
	 */
	public static String toJson(Object pojo, String... filterNames)
			throws Exception {
		ObjectMapper objectMapper = getObjectMapper();
		SimpleFilterProvider fp = new SimpleFilterProvider();
		if (filterNames != null && filterNames.length > 0) {
			fp.addFilter(FILTER_NAME,SimpleBeanPropertyFilter.serializeAllExcept(filterNames));
		} 
		fp.setFailOnUnknownId(false);
		ObjectWriter writer = objectMapper.writer(fp);
		return writer.writeValueAsString(pojo);
	}

	public static ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat dateFormate = new SimpleDateFormat(JSON_DATE_FROMATE);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setDateFormat(dateFormate);
		return objectMapper;
	}

	public static String toJson(Object pojo) throws Exception {
		return toJson(pojo);
	}

}
