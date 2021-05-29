package com.abhay.sb.util;

import org.springframework.stereotype.Component;

import com.abhay.sb.model.CrickInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DatConverterUtil {
	
	
	
	public String toString(CrickInfo info)
	
	{
		String data=null;
		
		try {
			data=new ObjectMapper().writeValueAsString(info);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
		
	}

	
	public CrickInfo toObject(String data)
	{
		CrickInfo info = null;
		
		try {
			info= new ObjectMapper().readValue(data, CrickInfo.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 return info;	
		
	}
}
 