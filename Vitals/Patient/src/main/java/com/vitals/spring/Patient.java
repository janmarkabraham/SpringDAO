package com.vitals.spring;

import java.util.List;
import java.util.GregorianCalendar;
import org.springframework.beans.factory.annotation.*;

public class Patient {
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private Room room;
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
	
}
