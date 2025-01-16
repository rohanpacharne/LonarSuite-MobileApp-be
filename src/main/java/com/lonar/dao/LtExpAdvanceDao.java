package com.lonar.dao;

import com.lonar.model.ExpenseApprovalV;

public interface LtExpAdvanceDao {
	
	Long getPendingCount(String status1, String approvalId, ExpenseApprovalV input) throws Exception;

}
