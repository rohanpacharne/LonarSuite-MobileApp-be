package com.lonar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.dao.ExpenseApprovalVDao;
import com.lonar.model.ExpenseApprovalV;

@Service
public class ExpenseApprovalVserviceImpl implements ExpenseApprovalVservice {
	
	@Autowired
	ExpenseApprovalVDao ExpenseApprovalVDao;
	
	@Transactional
	@Override
	public Long getCount(String status1, String approvalId, ExpenseApprovalV input) throws Exception
	{
		return ExpenseApprovalVDao.getCount(status1,approvalId,input);
	}
	
	@Transactional
	@Override
	public List<ExpenseApprovalV> getByStatus(String status,String approvalId,ExpenseApprovalV input) throws Exception
	{
		List<ExpenseApprovalV> list= ExpenseApprovalVDao.getByStatus(status,approvalId,input);
		
		for(ExpenseApprovalV obj : list) {
			if(obj.getStatus()==null) {
				obj.setStatus("");
			}
		}
		
		for(ExpenseApprovalV obj : list) {
			if(obj.getStatus().toUpperCase().equals("PENDING")) {
				obj.setAction("Approve/Reject");
			}else {
				obj.setAction("View");
			}
		}
		
		return list;
	}

	@Override
	public Long getPendingCount(String status1, String approvalId, ExpenseApprovalV input) {
		// TODO Auto-generated method stub
		return ExpenseApprovalVDao.getPendingCount(status1,approvalId,input);
	}

}
