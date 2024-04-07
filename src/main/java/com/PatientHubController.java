package com;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientHubController {
	
	@Autowired
	PatientsHubService patientsHubService;
	
	@GetMapping("/patientshub/getPatient/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("id") int id) {
		try {
			Patient patient = patientsHubService.getPatientById(id);
			return ResponseEntity.ok(patient);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Patient data not found for id "+id);
		}
		
	}
	
	@PostMapping("/patientshub/create")
	public ResponseEntity<Object> createNewPatient(@RequestBody Patient patient) {
		try {
			return patientsHubService.save(patient)==1 ? ResponseEntity.ok("1 Record saved successfully!!") 
					: ResponseEntity.ok("No Record Saved");
		}catch(Exception e) {
			Map<String, Object> body = new HashMap<>();
		    body.put("message", e.getMessage());

		    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/patientshub/deletePatient/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id) {
		try {
			return patientsHubService.delete(id) ? ResponseEntity.ok("1 Record deleted successfully!!") 
					: ResponseEntity.ok("No Record deleted!!");
		}catch(Exception e) {
			Map<String, Object> body = new HashMap<>();
		    body.put("message", e.getMessage());

		    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/patientshub/update/{id}")
	public  ResponseEntity<Object> updateOrCreate(@RequestBody Patient patient, @PathVariable int id) {
		try {
			return patientsHubService.update(patient,id) ? ResponseEntity.ok("1 Record updated successfully!!") 
					: ResponseEntity.ok("No Record updated!!");
		}catch(Exception e) {
			Map<String, Object> body = new HashMap<>();
		    body.put("message", e.getMessage());

		    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
	    Map<String, Object> body = new HashMap<>();
	    body.put("message", ex.getMessage());

	    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

}
