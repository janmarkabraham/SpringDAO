package com.vitals.spring;


import java.util.Scanner;
import java.lang.String;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.annotation.*;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	DaoInt dao = (DaoInt)context.getBean("DaoImp");
    	Database db = (Database)context.getBean("database");
    	Menu menu = (Menu)context.getBean("menu");
    	Monitoring monitoring = (Monitoring)context.getBean("monitoring");
    	Patient patient;
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	int command1, command2;
    	do{
    		menu.mainMenu();
    		command1 = Integer.parseInt(scanner.nextLine());
    			switch (command1) {
    				case 1: 
    						dao.getPatients();
    						break;
    					
    				case 2:
    						patient = (Patient)context.getBean("patient");
    						System.out.println("Add new patient - Enter Details");
    						System.out.println("First Name:"); String firstname = scanner.nextLine().toUpperCase();
    						System.out.println("Last Name:"); String lastname = scanner.nextLine().toUpperCase();
    						System.out.println("Date of Birth (YYYY-MM-DD):"); String dob = scanner.nextLine().toUpperCase();
    						System.out.println("Gender (male/female):"); String gender = scanner.nextLine().toUpperCase();
    						dao.insertPatient(patient);
    						break;
	
    				case 3: System.out.println("ID of Patient to be edited: ");
    						String id = scanner.nextLine();
    						System.out.println("First:"); firstname = scanner.nextLine().toUpperCase();
    						System.out.println("Last Name:"); lastname = scanner.nextLine().toUpperCase();
    						System.out.println("Date of Birth (YYYY-MM-DD):"); dob = scanner.nextLine().toUpperCase();
    						System.out.println("Gender (male/female):"); gender = scanner.nextLine().toUpperCase();
    						boolean exists = db.editPatient(id, firstname, lastname, dob, gender);
    						if(!exists){
    							System.out.println("ID does not exist");
    						}
    						break;

    					
    				case 4: System.out.println("ID of Patient to be deleted: ");
    						id = scanner.nextLine();
    						exists = db.removePatient(id);
    						if(!exists){
    							System.out.println("ID does not exist");
    						}
    						break;

    				case 5: System.out.println("ID of Patient to be viewed: ");
							id = scanner.nextLine();
							patient = db.getPatient(id);
							if(patient !=null){
								patient.printPatientWithMonitoring();
							}
							if(patient == null){
								System.out.println("ID does not exist");
							}
							break;

    				case 6: System.out.println("ID of Patient: ");
							id = scanner.nextLine();
							patient = db.getPatient(id);
							if(patient !=null){
								System.out.println("Date(YYYY-MM-DD HH:HH :"); String date = scanner.nextLine().toUpperCase();
								System.out.println("Blood Pressure :"); String bp = scanner.nextLine().toUpperCase();
								System.out.println("Heart Rate :"); String hr = scanner.nextLine().toUpperCase();
								System.out.println("Respiratory Rate :"); String rr = scanner.nextLine().toUpperCase();
								System.out.println("Temperature :"); String temp = scanner.nextLine().toUpperCase();
								patient.addMonitoring(monitoring, bp, hr, rr, temp, date);
								System.out.println("Monitoring data added");
							}
							if(patient == null){
								System.out.println("ID does not exist");
							}
							break;
    			}
    		} while (command1 != 7);
    		
    		System.out.println(" Bye ! ");

    }
}
