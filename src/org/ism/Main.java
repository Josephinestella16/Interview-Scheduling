package org.ism;
import java.util.Scanner;

import org.ism.controller.CandidateController;
import org.ism.controller.InterviewController;
import org.ism.controller.RequirementController;
import org.ism.controller.ResultController;
public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Choose your Role : \n1.Candidate\n2.HR");
		int n = in.nextInt();
		switch(n){
			case 1:
				CandidateController.registerCandidate();
				break;
			case 2:
				System.out.println("Choose your operation :\n1.Add Requirement\n2.Edit Requirement\n3.Schedule Interview\n4.Enter marks for interview");
				int x = in.nextInt();
				switch(x) {
					case 1:
						RequirementController.addRequirement();
						break;
					case 2:
						RequirementController.editRequirement();
						break;
					case 3:
						InterviewController.interviewSchedule();
						break;
					case 4:
						ResultController.markCalculator();
						break;
					default:
						System.out.println("Enter Valid Operation Number!");
						break;
				}
				break;
			default:
				System.out.println("Enter Valid Operation Number!");
				break;
		}
		
	}
}

