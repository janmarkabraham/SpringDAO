package com.vitals.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.*;

public class Database {
	private List<Patient> patientList;
	
	
	public List<Patient> getPatientList() {
		return patientList;
	}
	
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

}
