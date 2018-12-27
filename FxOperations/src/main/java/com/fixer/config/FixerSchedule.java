package com.fixer.config;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fixer.service.IFixerService;

@Component
public class FixerSchedule {
	
	@Autowired
	private IFixerService service;
	
	//@Scheduled(cron="0 */1 * * * *")
	@Scheduled(cron = "${rates.refresh.cron}")
	public void task() {
		System.out.println("task scheduled by every 1 min");
		
		service.deleteTotalCurrencyRates();
		System.out.println("data deleted");
		try {
			service.saveCurrencyData();
			System.out.println("data saved");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
