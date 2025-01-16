package com.lonar.dao;

import java.util.List;

import com.lonar.model.ExpenseApprovalV;


public interface ExpenseApprovalVDao {
	
	Long getCount(String status1, String approvalId, ExpenseApprovalV input) throws Exception;
	
	Long getPendingCount(String status1, String approvalId, ExpenseApprovalV input);
	
	List<ExpenseApprovalV> getByStatus(String status,String approvalId,ExpenseApprovalV input) throws Exception;

}
