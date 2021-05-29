package com.abhay.sb.consumer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.abhay.sb.model.CrickInfo;
import com.abhay.sb.service.MessageStoreService;
import com.abhay.sb.util.DatConverterUtil;

@Component
public class ConsumerService {

	@Autowired
	private MessageStoreService  service;
	
	@Autowired
	private DatConverterUtil util;
	
	@KafkaListener(topics = "${my.app.tpcName}",groupId = "groupId")
	public void readData(String data)
	
	{
		CrickInfo info=util.toObject(data);
		info.setMatchdate(new Date());
		service.addCrickInfoData(info);
		System.out.println("Data Saved from Consumer App after reading from Kakfka Using Message Strore Service");
	}
}
