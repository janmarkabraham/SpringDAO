package com.vitals.spring;

import java.util.List;
import java.util.GregorianCalendar;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.*;

public class Patient {
	private String patientId;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private Room room;
	
	@Resource(name="monitoringEx")
	private List<Monitoring> monitoringList; 
	

	public List<Monitoring> getMonitoringList() {
		return monitoringList;
	}
	
	public void setMonitoringList(List<Monitoring> monitoringList) {
		this.monitoringList = monitoringList;
	}
	

	public Room getRoom() {
		return room;
	}
	
	@Autowired
	@Qualifier("roomEx")	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public void addMonitoring(Monitoring monitoring, String bp, String hr, String rr, String temp, String date){
		monitoring.setDateTime(date);
		monitoring.setBloodPressure(bp);
		monitoring.setHeartRate(hr);
		monitoring.setRespiratoryRate(rr);
		monitoring.setTemperature(temp);
		monitoringList.add(monitoring);		
	}
	
	public void printPatient(){
		System.out.println("Patient Details:");
		System.out.println(this.patientId);
		System.out.println(this.firstName);
		System.out.println(this.lastName);
		System.out.println(this.dob);
		System.out.println(this.gender);	
	}
	
	public void printPatientWithMonitoring(){
		System.out.println("Patient Details:");
		System.out.println(this.patientId);
		System.out.println(this.firstName);
		System.out.println(this.lastName);
		System.out.println(this.dob);
		System.out.println(this.gender);
		System.out.println("Monitoring:");
		for(Monitoring monitoring: this.monitoringList){
			monitoring.printMonitoring();
		}
		
	}
	
}
