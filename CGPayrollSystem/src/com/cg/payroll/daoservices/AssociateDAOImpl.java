package com.cg.payroll.daoservices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.util.PayrollDBUTIL;

public class AssociateDAOImpl implements AssociateDAO {

		public Associate save(Associate associate) {
			associate.setAssociateId(PayrollDBUTIL.getASSOCIATE_ID_COUNTER());
			PayrollDBUTIL.associates.put(associate.getAssociateId(), associate);
			return associate;
		}
	

	@Override
	public boolean update(Associate associate) {
		return false;
	}

	@Override
	public Associate findOne(int associateId) {
		return PayrollDBUTIL.associates.get(associateId);
	}

	@Override
	public List<Associate> findAll() {
		
		return new ArrayList<Associate>(PayrollDBUTIL.associates.values());
	}
	

}
