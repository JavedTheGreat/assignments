package com.cg.payroll.beans;

public class Associate
{	
	private int associateId;
	private int yearlyInvestmentUnder80C;
	private String firstName,lastName,department,designation,pancard,emailId;
	public Salary salary;
	private BankDetails bankdetails;
	
	public Associate() {
	}
	public Associate(int associateId, int yearlyInvestmentUnder80C, String firstName, String lastName,
			String department, String designation, String pancard, String emailId ) {
		super();
		this.associateId = associateId;
		this.yearlyInvestmentUnder80C = yearlyInvestmentUnder80C;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.designation = designation;
		this.pancard = pancard;
		this.emailId = emailId;
		 
	}
	public Associate(int yearlyInvestmentUnder80C, String firstName, String lastName, String department,
			String designation, String pancard, String emailId,int basicSalary, int epf, int companyPf,int accountNumber, String bankName, String ifscCode, Salary salary, BankDetails bankDetails ) {
		super();
		this.yearlyInvestmentUnder80C = yearlyInvestmentUnder80C;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.designation = designation;
		this.pancard = pancard;
		this.emailId = emailId;
		this.salary= salary;
		 this.bankdetails =bankDetails;
	}
	public int getAssociateId() {
		return associateId;
	}

	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}

	public int getYearlyInvestmentUnder80C() {
		return yearlyInvestmentUnder80C;
	}

	public void setYearlyInvestmentUnder80C(int yearlyInvestmentUnder80C) {
		this.yearlyInvestmentUnder80C = yearlyInvestmentUnder80C;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
//	public Salary getSalary() {
	//	return salary;
//	}
//	public void setSalary(Salary salary) {
//		this.salary = salary;
//	}
//	public BankDetails getBankdetails() {
//		return bankdetails;
//	}
	public void setBankdetails(BankDetails bankdetails) {
		this.bankdetails = bankdetails;
	}
	@Override
	public String toString() {
		return "Associate [associateId=" + associateId + ", firstName=" + firstName + ", lastName=" + lastName + "\ndepartment=" + department
				+ ", designation=" + designation + ", pancard=" + pancard + ", emailId=" + emailId + "\nsalary="
				+ salary + "\nbankdetails=" + bankdetails + ", yearlyInvestmentUnder80C=" + yearlyInvestmentUnder80C
				+ "]";
	}
}
