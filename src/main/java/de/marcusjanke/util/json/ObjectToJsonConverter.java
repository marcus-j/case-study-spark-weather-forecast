package de.marcusjanke.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author marcus
 *
 */
public class ObjectToJsonConverter {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	private ObjectToJsonConverter() {
	}

	/**
	 * convert object to JSON using Jackson
	 * 
	 * @param object
	 * @return JSON string
	 * @throws JsonProcessingException
	 */
	public static String toJson(Object object) throws JsonProcessingException {
		return objectMapper.writeValueAsString(object);
	}
}
