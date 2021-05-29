package com.abhay.sb.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.abhay.sb.model.CrickInfo;
import com.abhay.sb.util.DatConverterUtil;

@Component
public class ProducerService {

	@Autowired
	private KafkaTemplate<String, String>  template;
	
	@Autowired
	
	private DatConverterUtil util;
	
	@Value("${my.app.tpcName}")
	private String topic;
	
	public void sendData(
			CrickInfo info)
	{
		String json=util.toString(info);
		
		template.send(topic, json);
	}
}
