package com.vitals.spring;

public class Monitoring {
	String dateTime;
	String bloodPressure;
	String heartRate;
	String respiratoryRate;
	String temperature;
	
	public String getBloodPressure() {
		return bloodPressure;
	}
	
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	
	public String getHeartRate() {
		return heartRate;
	}
	
	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}
	
	public String getRespiratoryRate() {
		return respiratoryRate;
	}
	
	public void setRespiratoryRate(String respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}
	
	public String getTemperature() {
		return temperature;
	}
	
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	public void printMonitoring(){
		System.out.println(this.dateTime);
		System.out.println(this.bloodPressure);
		System.out.println(this.heartRate);
		System.out.println(this.respiratoryRate);
		System.out.println(this.temperature);	
	}

	
	
			
}
