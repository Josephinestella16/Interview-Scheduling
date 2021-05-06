package org.ism.controller;

import java.util.Scanner;


import org.ism.model.Candidate;
import org.ism.services.InterviewServiceImpl;
@SuppressWarnings("resource")
public class ResultController {

	static InterviewServiceImpl service = new InterviewServiceImpl();
	

	public static void markCalculator() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Requirement ID :");
		int reqId = in.nextInt();
		in.nextLine();
		if(service.isPresent(reqId)) {
			System.out.println("Enter Interview ID :");
			String interviewId = in.nextLine();
			if(service.isChecked(interviewId)) {
				//1:1 --> reqId:candidateNumber
				int candidateNumber = Integer.parseInt(interviewId.split(":")[1]);
				//get candidate details
				Candidate candidate = service.getCandidateDetails(candidateNumber);
				String result = "";
				System.out.println("Enter Marks : ");
				int mark = in.nextInt();
				if(mark < 50) {
					result = "Rejected";
				}else if(mark >= 50 && mark < 70) {
					if(candidate.getRank().equals("R2") || candidate.getRank().equals("R3"))
						result = "Rejected";
					else if(candidate.getRank().equals("R1"))
						result = "Selected";
				}else if(mark >= 70 && mark < 80) {
					if(candidate.getRank().equals("R2") || candidate.getRank().equals("R1"))
						result = "Selected";
					else if(candidate.getRank().equals("R3"))
						result = "Rejected";
				}else {
					result = "Selected";
				}
				
				if(result.equals("Rejected")){
					service.changeToFalse(candidateNumber);					
				}else {
					service.reduce(reqId);
				}
				
				service.updateInterview(result,interviewId);
				System.out.println("Marks uploaded successfully!");			
			}else {
				System.out.println("Marks is uploaded for the interview already or Interview doesn't exist!");
			}
		}else {
			System.out.println("Requirement Not Found!");
		}
	}
	
}