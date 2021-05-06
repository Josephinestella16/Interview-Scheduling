package org.ism.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.ism.model.Requirement;
import org.ism.services.RequirementServiceImpl;
@SuppressWarnings("resource")
public class RequirementController {


	public static void addRequirement() {
		Scanner in =new Scanner(System.in);
		System.out.println("Enter Employee ID:");
		String employeeID = in.nextLine();
		System.out.println("Enter Domain:");
		String domain = in.nextLine();
		System.out.println("Enter Required Vacancies(1 to 5):");
		int vacancies = in.nextInt();
		in.nextLine();
		System.out.println("Enter Closing Date:");
		String closingDate = in.nextLine();
		System.out.println("Enter Priority:");
		String priority = in.nextLine(),mode;
		System.out.println("Enter Minimum Experience(1 to 12):");
		int exp = in.nextInt();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		   LocalDateTime now = LocalDateTime.now();  
		   String reqDate = dtf.format(now);
		
		if(vacancies <= 3) {
			if(exp <= 3) {
				mode = "Online Test";
			}else if(exp <= 6) {
				mode = "In Person";
			}else {
				mode = "Telephonic";
			}
		}else {
			if(exp <= 3) {
				mode = "Online Test";
			}else if(exp <= 6) {
				mode = "Online Test";
			}else {
				mode = "In Person";
			}
		}
		
		Requirement req = new Requirement(employeeID,domain,vacancies,reqDate,closingDate,priority,exp,mode);
		RequirementServiceImpl service = new RequirementServiceImpl();
		boolean flag = service.addRequirement(req);
		if(flag) {
			System.out.println("Requirement Added Successfully");
		}else {
			System.out.println("Requirement Addition Failed!..");
		}
	}
	
	
	public static void editRequirement() {
		Scanner in = new Scanner(System.in);
		RequirementServiceImpl service = new RequirementServiceImpl();
		System.out.println("Enter Requirement ID : ");
		int reqId = in.nextInt();
		in.nextLine();
		boolean flag = service.editRequirement(reqId);
		if(flag) {
			System.out.println("Enter Employee Id : ");
			String employeeId = in.nextLine();
			System.out.println("Enter Domain:");
			String domain = in.nextLine();
			System.out.println("Enter Required Vacancies(1 to 5):");
			int vacancies = in.nextInt();
			in.nextLine();
			System.out.println("Enter Closing Date:");
			String closingDate = in.nextLine();
			System.out.println("Enter Priority");
			String priority = in.nextLine(),mode;
			System.out.println("Enter Minimum Experience(1 to 12):");
			int exp = in.nextInt();
			

			if(vacancies <= 3) {
				if(exp <= 3) {
					mode = "Online Test";
				}else if(exp <= 6) {
					mode = "In Person";
				}else {
					mode = "Telephonic";
				}
			}else {
				if(exp <= 3) {
					mode = "Online Test";
				}else if(exp <= 6) {
					mode = "Online Test";
				}else {
					mode = "In Person";
				}
			}
			String reqDate = null;
			Requirement requirement = new Requirement(employeeId,domain,vacancies,reqDate,closingDate,priority,exp,mode);
			boolean b = service.edit(requirement,reqId);
			if(b)
				System.out.println("Requirement Edited Successfully");
			else
				System.out.println("Requirement Edit Failed!..");
		}else
			System.out.println("Not Present");
	}
}
