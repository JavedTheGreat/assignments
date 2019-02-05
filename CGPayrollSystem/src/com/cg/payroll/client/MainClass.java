package com.cg.payroll.client;
import com.cg.payroll.exceptions.AssociateDetailNotfoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
public class MainClass {
	public static void main(String[] args) throws AssociateDetailNotfoundException{
		PayrollServices services=new PayrollServicesImpl();
		int associateId= services.acceptAssociateDetails("Javed", "Syed", "jazz.takkar@gmail.com", "IT", "Analyst", "ABC123", 2500, 8522, 100, 52, 0, 78545555, "HDFC", "jj4582");
		System.out.println("Associate Id "+ associateId);
		System.out.println("Net Salary :-"+services.calculateNetSalary(associateId));
		System.out.println(services.getAssociateDetails(associateId));
	//	System.out.println(services.calculateNetSalary(associateId1));

	}

}
