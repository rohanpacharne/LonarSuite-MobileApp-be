package com.lonar.dao;

import com.lonar.model.InvoiceApproval;
import com.lonar.model.VendorApproval;

public interface LtInvoiceDao {
	
	Long getPendingCount(String status1, String approvalId, InvoiceApproval input) throws Exception;


}
