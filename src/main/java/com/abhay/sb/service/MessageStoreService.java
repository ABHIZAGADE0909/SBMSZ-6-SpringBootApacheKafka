package com.abhay.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.abhay.sb.model.CrickInfo;
import com.abhay.sb.repo.CrickInfoRepository;

@Service
public class MessageStoreService {

	@Autowired
	private CrickInfoRepository  repo;
	
	public void addCrickInfoData(CrickInfo info)
	{
		repo.save(info);
	}
	
	public List<CrickInfo> getAllData()
	{
		
		return repo.findAll();
	}
}
