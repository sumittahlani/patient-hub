package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientsHubService {
	
	@Autowired
	PatientsHubDao patientsHubDao;
	
	public Patient getPatientById(int id) {
		return patientsHubDao.getPatientById(id);
	}
	
	public int save(Patient patient) {
		return patientsHubDao.save(patient);
	}

	public boolean delete(int id) {
		return patientsHubDao.delete(id);
	}

	public boolean update(Patient patient, int id) {
		
		return patientsHubDao.update(patient,id);
	}
}
