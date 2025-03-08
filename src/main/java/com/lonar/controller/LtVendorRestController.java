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
import com.lonar.model.LtInvoiceHeaders;
import com.lonar.model.LtMastVendors;
import com.lonar.model.LtVendorApproval;
import com.lonar.model.Status;
import com.lonar.service.LtInvoiceService;
import com.lonar.service.LtVendorService;

@RestController
@RequestMapping(value = "/vendor")
public class LtVendorRestController {
	
	@Autowired
	LtVendorService ltVendorService;
	
	@PostMapping("/vendorById")
    public ResponseEntity<LtMastVendors> getInvoiceHeader(@RequestBody LtMastVendors ltMastVendors) {
        return ltVendorService.getVendorByVendorId(ltMastVendors.getVendorId(), ltMastVendors.getApprovalId(), ltMastVendors.getToken());
	}
	
	@PostMapping("/vendorApprovalByVendorId")
    public List<LtVendorApproval> getVendorApprovalByVendorId(@RequestBody LtMastVendors ltMastVendors) {
        return ltVendorService.getVendorApprovalByVendorId(ltMastVendors.getVendorId(), ltMastVendors.getToken());
	}
	
	@PostMapping("/approved")
    public Status approveFeedbackReject(@RequestBody ApproveFeedbackReject approveFeedbackReject) {
    	return ltVendorService.approveFeedbackReject(approveFeedbackReject);
    }
	
	@PostMapping("/saveBulkVendors")
    public ResponseEntity<Status> saveBulkVendors(@RequestBody InboxBulkInput inboxBulkInput) {
    	return ltVendorService.saveBulkVendors(inboxBulkInput);
    }

}
