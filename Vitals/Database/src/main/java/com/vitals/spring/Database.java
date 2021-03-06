package com.vitals.spring;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.*;

public class Database {
	@Resource(name="patientEx")
	private List<Patient> patientList;
	
	
	public List<Patient> getPatientList() {
		return patientList;
	}
	
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
	
	public Patient getPatient(String id) {
		for(Patient patient: patientList){
			if(id.equalsIgnoreCase(patient.getPatientId())){
				return patient;
			}		
		}
		return null;
	}
	
	public void addPatient(Patient patient, String firstname, String lastname, String dob, String gender){
		String idNumber = (String.format("%04d", this.patientList.size()+1)).toString();
		patient.setFirstName(firstname);
		patient.setLastName(lastname);
		patient.setDob(dob);
		patient.setGender(gender);
		patient.setPatientId(idNumber);	
		this.patientList.add(patient);
		System.out.println("Patient added!");
	}
	
	
	public boolean removePatient(String id){
		for(Patient patient: patientList){
			if(id.equalsIgnoreCase(patient.getPatientId())){
				patientList.remove(patient);
				System.out.println("Patient deleted!");
				return true;
			}			
		}
		return false;
	}
	
	public boolean editPatient(String id, String firstname, String lastname, String dob, String gender){
		for(Patient patient: patientList){
			if(id.equalsIgnoreCase(patient.getPatientId())){
				patient.setFirstName(firstname);
				patient.setLastName(lastname);
				patient.setDob(dob);
				patient.setGender(gender);
				System.out.println("Patient updated!");
				return true;
			}
		}
		return false;
	}
	
	public void printDatabase(){
		System.out.println("=============== PATIENT DATABASE ==============");
		for(Patient patient: patientList){
			patient.printPatient();
			System.out.println("-----------------------------------");
		}
	}
}
