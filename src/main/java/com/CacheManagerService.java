package com;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CacheManagerService {
	
	
	@CacheEvict(value = "patients", allEntries = true)
	@Scheduled(fixedRate = 60000)
	public void emptyPatientsCache() {
	    System.out.println("Eviction....");
	}
}
