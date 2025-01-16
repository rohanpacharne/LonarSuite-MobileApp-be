package com.lonar.service;

import com.lonar.model.ExpenseApprovalV;

public interface LtExpAdvanceService {
	
	Long getPendingCount(String status1, String approvalId, ExpenseApprovalV input) throws Exception;


}
