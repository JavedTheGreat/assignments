package com.cg.payroll.services;

import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.daoservices.AssociateDAOImpl;
import com.cg.payroll.exceptions.AssociateDetailNotfoundException;

public class PayrollServicesImpl implements PayrollServices {
private AssociateDAO associateDao = new AssociateDAOImpl();
	
	@Override
	public int acceptAssociateDetails(String firstName, String lastName, String emailId, String department,
			String designation, String pancard, int yearlyInvestmentUnder80C, int basicSalary, int hra, int epf,
			int companyPf, int accountNumber, String bankName, String ifscCode) {
		
		Associate associate= new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, basicSalary, epf, companyPf, accountNumber, bankName, ifscCode,new Salary(basicSalary, epf, companyPf),new BankDetails(accountNumber, bankName, ifscCode));
		associate = associateDao.save(associate);
		return associate.getAssociateId();
	}
	@Override
	public int calculateNetSalary(int associateId) throws AssociateDetailNotfoundException {
		Associate associate = getAssociateDetails(associateId);
		associate.salary.setHra((associate.salary.getBasicSalary()*30)/100);	
		associate.salary.setConveyenceAllowance((associate.salary.getBasicSalary()*30)/100);
		associate.salary.setPersonalAllowance((associate.salary.getBasicSalary()*20)/100);
		associate.salary.setOtherAllowance((associate.salary.getBasicSalary()*30)/100);
		
		associate.salary.setNetSalary(((associate.salary.getBasicSalary()+associate.salary.getHra()+associate.salary.getConveyenceAllowance()+associate.salary.getOtherAllowance()
		+associate.salary.getPersonalAllowance())-(associate.salary.getCompanyPf()+associate.salary.getEpf()))*12);
	//	return associate.salary.getNetSalary();
		//Gross?
		
		int netSalary;
		int monthlyGrossSalary =(associate.salary.getBasicSalary() + associate.salary.getHra() + associate.salary.getPersonalAllowance() + associate.salary.getOtherAllowance() + associate.salary.getConveyenceAllowance() + associate.salary.getCompanyPf()
		+ associate.salary.getEpf());
		int annualGrossSalary =(monthlyGrossSalary*12);
		int investment = associate.getYearlyInvestmentUnder80C()+associate.salary.getCompanyPf()+associate.salary.getEpf();
		if(investment >= 1500000)
			investment = 1500000;
		if(annualGrossSalary < 250000)
			netSalary = annualGrossSalary - associate.salary.getEpf() - associate.salary.getCompanyPf();
		else if(annualGrossSalary >= 250000 && annualGrossSalary < 500000)
			netSalary = (int) (annualGrossSalary -((annualGrossSalary-investment)*0.1) - associate.salary.getEpf() - associate.salary.getCompanyPf());
		else if(annualGrossSalary >= 500000 && annualGrossSalary < 1000000)
		{
			int t2 = (int)((annualGrossSalary - 500000)*0.2);
			int t1 = (int)((250000 - investment) *0.1);
			netSalary = annualGrossSalary - t1 - t2 - associate.salary.getCompanyPf() - associate.salary.getEpf();
		}
		else 
		{	int t3 = (int)((annualGrossSalary - 1000000) *0.3);
			int t2 = 1000000;
			int t1 = (int)((250000 - investment)*0.1);
			netSalary = annualGrossSalary - t1 - t2 -t3- associate.salary.getCompanyPf() - associate.salary.getEpf();
		}
			return associate.salary.setNetSalary(netSalary);
	}
	@Override
	public Associate getAssociateDetails(int associateId) throws AssociateDetailNotfoundException {
	Associate associate= associateDao.findOne(associateId);
	if(associate==null)
		throw new AssociateDetailNotfoundException("Associate details not found for Id" + associateId);
		return associate;
	}
	@Override
	public List<Associate> getAllAssociateDetails() {
		
		return associateDao.findAll();
}}