package com.lonar.dao;

import com.lonar.model.ApproveFeedbackReject;
import com.lonar.model.Status;
import com.lonar.model.VendorApproval;

public interface LtVendorDao {
	
	Long getPendingCount(String status1, String approvalId, VendorApproval input) throws Exception;


}
