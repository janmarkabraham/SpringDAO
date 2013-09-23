package com.vitals.spring;

import java.util.List;

public interface DaoInt {
	void insertPatient(Patient patient);
	Patient getPatientById(int patientId);
	Patient getPatient(String patientname);
	List<Patient> getPatients();	
}
