package com.abhay.sb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhay.sb.model.CrickInfo;
import com.abhay.sb.producer.ProducerService;
import com.abhay.sb.service.MessageStoreService;

@RestController
@RequestMapping("/cricinfo")
public class CrickInfoRestController {

	@Autowired
	private ProducerService prodService;
	
	@Autowired
	private MessageStoreService msgService;
	
	@PostMapping("/add")
	public ResponseEntity<String> sendDataToProDucer(@RequestBody CrickInfo info)
	{
		
		prodService.sendData(info);
		
		System.out.println("RestController Recevied Data From Postman & now sedning data to prodcuer");
		
		return ResponseEntity.ok("Data Saved");
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CrickInfo>> getAllData()
	{
		List<CrickInfo> list=msgService.getAllData();
		return ResponseEntity.ok(list);
	}
}
