package com.lonar.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.lonar.model.ApproveFeedbackReject;
import com.lonar.model.InboxBulkInput;
import com.lonar.model.InvoiceApproval;
import com.lonar.model.LtExpExpenseHeaders;
import com.lonar.model.LtExpenseApprovalHistory;
import com.lonar.model.LtInvoiceHeaders;
import com.lonar.model.LtVendorApproval;
import com.lonar.model.Status;
import com.lonar.model.VendorApproval;

public interface LtInvoiceService {
	
	ResponseEntity<LtInvoiceHeaders> getInvoiceByHeaderById(Long long1, Long approvalId,String token);
	
	List<LtVendorApproval> getApprovalByHeaderId(Long headerId, String token);
	
	Status approveFeedbackReject(ApproveFeedbackReject approveFeedbackReject);
	
	Long getPendingCount(String status1, String approvalId, InvoiceApproval input) throws Exception;
	
	public ResponseEntity<Status> saveBulkInvoices(@RequestBody InboxBulkInput inboxBulkInput);
	
	public boolean checkStatusIsPending(Long headerId, Long approvalId,String token);


}
