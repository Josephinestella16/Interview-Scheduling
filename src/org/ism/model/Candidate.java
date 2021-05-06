package org.ism.model;


public class Candidate {

	private String firstName;
	private String lastName;
	private String password;
	private String dob;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String contactNumber;
	private String degree;
	private String yop;
	private String marks;
	private String email;
	private String domain;
	private int yoe;
	private String companyHistory;
	private String rank;
	private String jobType;
	private boolean status;
	private int candidateNumber;
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidate(String firstName, String lastName, String password, String dob,
			String address, String city, String state, String pincode, String contactNumber, String degree, String yop,
			String marks, String email, String domain, int yoe, String companyHistory, String rank, String jobType,
			boolean status,int candidateNumber) {
		super();
		this.candidateNumber = candidateNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.contactNumber = contactNumber;
		this.degree = degree;
		this.yop = yop;
		this.marks = marks;
		this.email = email;
		this.domain = domain;
		this.yoe = yoe;
		this.companyHistory = companyHistory;
		this.rank = rank;
		this.jobType = jobType;
		this.status = status;
	}
	public int getCandidateNumber() {
		return candidateNumber;
	}
	public void setCandidateNumber(int candidateNumber) {
		this.candidateNumber = candidateNumber;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getYop() {
		return yop;
	}
	public void setYop(String yop) {
		this.yop = yop;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getYoe() {
		return yoe;
	}
	public void setYoe(int yoe) {
		this.yoe = yoe;
	}
	public String getCompanyHistory() {
		return companyHistory;
	}
	public void setCompanyHistory(String companyHistory) {
		this.companyHistory = companyHistory;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Candidate [candidateNumber=" + candidateNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", dob=" + dob + ", address=" + address + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", contactNumber=" + contactNumber + ", degree=" + degree + ", yop="
				+ yop + ", marks=" + marks + ", email=" + email + ", domain=" + domain + ", yoe=" + yoe
				+ ", companyHistory=" + companyHistory + ", rank=" + rank + ", jobType=" + jobType + ", status="
				+ status + "]";
	}
	
	
	
	
}

