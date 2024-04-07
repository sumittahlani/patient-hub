package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PatientsHubDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Cacheable("patients")
	public Patient getPatientById(int id) {
		return jdbcTemplate.queryForObject("select * from patients where id=? ", new BeanPropertyRowMapper<>(Patient.class),id);
	}

	public int save(Patient patient) {
		return jdbcTemplate.update("INSERT INTO PATIENTS (ID, NAME) VALUES (?, ?)", patient.getId(), patient.getName());
	}

	public boolean delete(int id) {
		
		return jdbcTemplate.update("DELETE FROM PATIENTS WHERE ID=?", id)==1;
	}

	public boolean update(Patient patient, int id) {
		return jdbcTemplate.update("UPDATE PATIENTS SET NAME=? WHERE ID=?", patient.getName(), id)==1;
	}
}
