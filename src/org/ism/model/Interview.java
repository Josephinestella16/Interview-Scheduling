package org.ism.model;

public class Interview {

	private String interviewId;
	private String venue;
	private int reqId;
	private String interviewDate;
	private String rank;
	private String candidateName;
	private String qualification;
	private boolean status;
	private String result;
	public Interview() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Interview(String interviewId, String venue, int reqId, String interviewDate, String rank,
			String candidateName, String qualification, boolean status, String result) {
		super();
		this.interviewId = interviewId;
		this.venue = venue;
		this.reqId = reqId;
		this.interviewDate = interviewDate;
		this.rank = rank;
		this.candidateName = candidateName;
		this.qualification = qualification;
		this.status = status;
		this.result = result;
	}
	public String getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(String interviewId) {
		this.interviewId = interviewId;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public String getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	
}
