package org.ism.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.ism.model.Candidate;
import org.ism.model.Interview;
import org.ism.model.Requirement;
import org.ism.services.InterviewServiceImpl;

public class InterviewController {

	static InterviewServiceImpl service = new InterviewServiceImpl();
	
	@SuppressWarnings("resource")
	public static void interviewSchedule() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Requirement Id : ");
		int reqId = in.nextInt();
		in.nextLine();
		if(service.checkReqId(reqId)) {
			Requirement req = service.getReq(reqId);
			List<Candidate> candidates = service.getCandidates(req.getDomain(), req.getExperience(), req.getVacancies());
			if(candidates.size()==0) {
				System.out.println("No candidate found");
				
			}
			for(Candidate c : candidates) {
				System.out.println("Requirement ID : "+reqId);
				System.out.println("Candidate Name : "+c.getFirstName()+" "+c.getLastName());
				System.out.println("Qualification : "+c.getDegree());
				System.out.println("Rank : "+c.getRank());
				System.out.println("Enter Venue : ");
				
				String venue = in.nextLine();
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date()); // Using today's date
				if(req.getPriority().equals("High")) {
					cal.add(Calendar.DATE, 5);					
				}else if(req.getPriority().equals("Normal")) {
					cal.add(Calendar.DATE, 10);
				}else {
					cal.add(Calendar.DATE, 15);
				}
				String interviewDate = sdf.format(cal.getTime());
				service.change(c.getCandidateNumber());
				Interview interview = new Interview(reqId+":"+c.getCandidateNumber(),venue,reqId,interviewDate,c.getRank(),c.getFirstName()+" "+c.getLastName(),c.getDegree(),false,"NOT MARKED");
				if(service.saveInterview(interview))
					System.out.println("Interview Scheduled!");
				else
					System.out.println("Failed to Schedule Interview");
			}
		}else {
			System.out.println("Interview has been scheduled already!");
		}
	}
}
