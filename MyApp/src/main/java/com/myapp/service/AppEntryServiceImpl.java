package com.myapp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.model.AppEntry;
import com.myapp.repository.AppEntryRepo;
@Service
public class AppEntryServiceImpl implements AppEntryService {
	
	private static final Logger logger=LogManager.getLogger(AppEntryServiceImpl.class);

	@Autowired
	AppEntryRepo appEntRepo;
	
	@Override
	public String saveApplication(AppEntry appentry) {
		
		AppEntry saved = appEntRepo.save(appentry);
		logger.info("After Save "+saved.toString());
		return "Data is Saved";
	}

}
