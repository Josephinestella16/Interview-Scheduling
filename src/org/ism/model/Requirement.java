package org.ism.model;


public class Requirement {
	private int reqId;
	private String employeeId;
	private String domain;
	private int vacancies;
	private String requestDate;
	private String closingDate;
	private String priority;
	private int experience;
	private String mode;
	public Requirement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Requirement(String employeeId, String domain, int vacancies, String requestDate, String closingDate,
			String priority, int experience, String mode) {
		super();
		this.reqId = 0;
		this.employeeId = employeeId;
		this.domain = domain;
		this.vacancies = vacancies;
		this.requestDate = requestDate;
		this.closingDate = closingDate;
		this.priority = priority;
		this.experience = experience;
		this.mode = mode;
	}

	public int getReqId() {
		return reqId;
	}
	
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public int getVacancies() {
		return vacancies;
	}

	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "Requirement [reqId=" + reqId + ", employeeId=" + employeeId + ", domain=" + domain + ", vacancies="
				+ vacancies + ", requestDate=" + requestDate + ", closingDate=" + closingDate + ", priority=" + priority
				+ ", experience=" + experience + ", mode=" + mode + "]";
	}

	
	
}
