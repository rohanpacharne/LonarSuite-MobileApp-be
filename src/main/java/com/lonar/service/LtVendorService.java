package com.lonar.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.lonar.model.ApproveFeedbackReject;
import com.lonar.model.InboxBulkInput;
import com.lonar.model.LtInvoiceHeaders;
import com.lonar.model.LtMastVendors;
import com.lonar.model.LtVendorApproval;
import com.lonar.model.Status;
import com.lonar.model.VendorApproval;

public interface LtVendorService {
	
	ResponseEntity<LtMastVendors> getVendorByVendorId(Long long1, Long approvalId, String token);
	
	Long getPendingCount(String status1, String approvalId, VendorApproval input) throws Exception;
	
	List<LtVendorApproval> getVendorApprovalByVendorId(Long vendorId, String token);
	
	Status approveFeedbackReject(ApproveFeedbackReject approveFeedbackReject);
	
	public ResponseEntity<Status> saveBulkVendors(@RequestBody InboxBulkInput inboxBulkInput);
	
	public boolean checkStatusIsPending(Long vendorId, Long approvalId,String token);


}
