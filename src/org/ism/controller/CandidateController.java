package org.ism.controller;

import java.util.Scanner;

import org.ism.model.Candidate;
import org.ism.services.CandidateServiceImpl;

public class CandidateController {
	@SuppressWarnings("resource")
	public static void registerCandidate() {
		CandidateServiceImpl service = new CandidateServiceImpl();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter FirstName : ");
		String firstname = in.nextLine();
		System.out.println("\nEnter LastName: ");
		String lastname = in.nextLine();
		
		System.out.println("Enter email : ");
		String email = in.nextLine();
		if(service.checkEmail(email)){
			System.out.println("Enter Password : ");
			String password = in.nextLine();
			System.out.println("Enter DOB : ");
			String dob = in.nextLine();
			System.out.println("Enter Address : ");
			String address = in.nextLine();
			System.out.println("Enter city : ");
			String city = in.nextLine();
			System.out.println("Enter State : ");
			String state = in.nextLine();
			
			System.out.println("Enter pincode : ");
			String pincode = in.nextLine();
			System.out.println("Enter phone Number : ");
			String phone = in.nextLine();
			System.out.println("Enter degree : ");
			String degree = in.nextLine();
			System.out.println("Enter Year of passing : ");
			String yop = in.nextLine();
			System.out.println("Enter marks : ");
			String marks = in.nextLine();
			System.out.println("Enter domain : ");
			String domain = in.nextLine();
			System.out.println("Enter Year of Experience : ");
			int yoe = in.nextInt();
			in.nextLine();
			System.out.println("Enter History of Company : ");
			String company = in.nextLine(),rank,jobType;
			float num = Float.parseFloat(marks);
			if(degree.equals("BE") || degree.equals("BTech") || degree.equals("MCA")) {
				jobType = "Professional";
			}else {
				jobType="Non-Professional";
			}
			
			if(num >= 90) {
				if(jobType.equals("Professional"))
					rank = "R1";
				else
					rank = "R2";
			}else if(num >= 80) {
				if(jobType.equals("Professional"))
					rank = "R2";
				else
					rank = "R3";
			}else if(num >= 70) {
				if(jobType.equals("Professional"))
					rank = "R3";
				else
					rank = "R4";
			}else {
				rank = "R4";
			}
			
			
			Candidate candidate = new Candidate(firstname,lastname,password,dob,address,city,state,pincode,phone,degree,yop,marks,email,domain,yoe,company,rank,jobType,false,0);
			boolean b = service.registerCandidate(candidate);
			if(b)
				System.out.println("Success");
			else
				System.out.println("Failure");
			
		}else {
			System.out.println("Candidate email already exists!");
		}
		
	}
}

