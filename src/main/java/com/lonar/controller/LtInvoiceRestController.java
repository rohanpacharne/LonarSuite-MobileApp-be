package com.lonar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lonar.model.ApproveFeedbackReject;
import com.lonar.model.InboxBulkInput;
import com.lonar.model.LtExpExpenseHeaders;
import com.lonar.model.LtInvoiceHeaders;
import com.lonar.model.LtVendorApproval;
import com.lonar.model.Status;
import com.lonar.service.CombineAllApiService;
import com.lonar.service.LtInvoiceService;

@RestController
@RequestMapping(value = "/invoice")
public class LtInvoiceRestController {
	
	@Autowired
	LtInvoiceService ltInvoiceService;
	
	@PostMapping("/invoiceHeaderById")
    public ResponseEntity<LtInvoiceHeaders> getInvoiceHeader(@RequestBody LtInvoiceHeaders ltInvoiceHeaders) {
        return ltInvoiceService.getInvoiceByHeaderById(ltInvoiceHeaders.getInvoiceHeaderId(),ltInvoiceHeaders.getApprovalId() ,ltInvoiceHeaders.getToken());
	}
	
	@PostMapping("/invoiceApprovalByHeaderId")
    public List<LtVendorApproval> getApprovalByHeaderId(@RequestBody LtInvoiceHeaders ltInvoiceHeaders) {
        return ltInvoiceService.getApprovalByHeaderId(ltInvoiceHeaders.getInvoiceHeaderId(), ltInvoiceHeaders.getToken());
	}
	
	@PostMapping("/approved")
    public Status approveFeedbackReject(@RequestBody ApproveFeedbackReject approveFeedbackReject) {
    	return ltInvoiceService.approveFeedbackReject(approveFeedbackReject);
    }
	
	@PostMapping("/saveBulkInvoices")
    public ResponseEntity<Status> saveBulkExpenses(@RequestBody InboxBulkInput inboxBulkInput) {
    	return ltInvoiceService.saveBulkInvoices(inboxBulkInput);
    }

}
