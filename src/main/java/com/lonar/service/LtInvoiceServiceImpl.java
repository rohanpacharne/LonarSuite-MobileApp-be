package com.lonar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lonar.dao.LtInvoiceDao;
import com.lonar.model.ApproveFeedbackReject;
import com.lonar.model.CodeMaster;
import com.lonar.model.InboxBulkInput;
import com.lonar.model.InvoiceApproval;
import com.lonar.model.LtExpExpenseHeaders;
import com.lonar.model.LtExpenseApprovalHistory;
import com.lonar.model.LtInvoiceHeaders;
import com.lonar.model.LtVendorApproval;
import com.lonar.model.Status;
import com.lonar.model.VendorApproval;

@Service
public class LtInvoiceServiceImpl implements LtInvoiceService,CodeMaster {
	
	@Autowired
	LtInvoiceDao ltInvoiceDao;
	
	@Autowired
	LtNotificationService ltNotificationService;
	
	private final RestTemplate restTemplate = new RestTemplate();
	long currentTimestamp = System.currentTimeMillis();

	@Override
	public ResponseEntity<LtInvoiceHeaders> getInvoiceByHeaderById(Long headerId,Long approvalId, String token) {
		
		boolean status = checkStatusIsPending(headerId, approvalId, token);
		
		String apiUrl = lVendorMasterIp + "/lvendormaster/API/invoiceheader/getInvoiceById/"
                + headerId + "/" + currentTimestamp;

		try {
	        
	        HttpHeaders headers = new HttpHeaders();
	        //headers.set("Authorization", "Bearer " + token); // Added Authorization header
	        headers.set("access_token", token);
	        headers.set("Content-Type", "application/json");

	        HttpEntity<String> entity = new HttpEntity<>(headers); // Added HttpEntity with headers

	        ResponseEntity<LtInvoiceHeaders> response = restTemplate.exchange(
	                apiUrl,
	                HttpMethod.GET, 
	                entity,
	                LtInvoiceHeaders.class
	        );
	        
	        HttpHeaders responseHeaders = new HttpHeaders();
	        responseHeaders.set("checkStatusIsPending", String.valueOf(status));  // Add the status (true/false) as a header
	        
	        int res = ltNotificationService.updateReadFlag(headerId, "INVOICE");
	        
	        return new ResponseEntity<>(response.getBody(), responseHeaders, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch expense header: " + e.getMessage());
	    }
	}
	
	@Override
	public List<LtVendorApproval> getApprovalByHeaderId(Long headerId, String token) {

		String apiUrl = lVendorMasterIp + "/lvendormaster/API/approval/getApprovalByInvoiceId/"+
				headerId+ "/"+currentTimestamp ;
		
		try {
	        
	        HttpHeaders headers = new HttpHeaders();
	        //headers.set("Authorization", "Bearer " + token); // Added Authorization header
	        headers.set("access_token", token);
	        headers.set("Content-Type", "application/json");

	        HttpEntity<String> entity = new HttpEntity<>(headers); // Added HttpEntity with headers

	        ResponseEntity<List<LtVendorApproval>> response = restTemplate.exchange(
	        		apiUrl,
	                HttpMethod.GET,
	                entity,
	                new ParameterizedTypeReference<List<LtVendorApproval>>() {} // Expect a list of objects
	        );
	        
	        List<LtVendorApproval> vendorApprovals = response.getBody();
	        
	        for(LtVendorApproval ltVendorApproval:vendorApprovals) {
	        	ltVendorApproval.setInvoiceApprovalId(ltVendorApproval.getVendorApprovalId());
	        	ltVendorApproval.setInvoiceHeaderId(ltVendorApproval.getVendorId());
	        	ltVendorApproval.setVendorApprovalId(null);
	        	ltVendorApproval.setVendorId(null);
	        }


	        return vendorApprovals; 
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch expense header: " + e.getMessage());
	    }
	}

	@Override
	public Status approveFeedbackReject(ApproveFeedbackReject approveFeedbackReject) {
		
		String apiUrl = lVendorMasterIp + "/lvendormaster/API/invoiceapproval/updateInvoiceStatusApproval/";
           
		     try {
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("access_token", approveFeedbackReject.getToken());
	        headers.set("Content-Type", "application/json");

	        HttpEntity<Object> entity = new HttpEntity<>(approveFeedbackReject,headers); // Added HttpEntity with headers
	        ResponseEntity<Status> response = restTemplate.exchange(
	        		apiUrl,
	                HttpMethod.POST,
	                entity,
	                Status.class
	        );

	        return response.getBody(); 
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch expense header: " + e.getMessage());
	    }
	}

	@Override
	public Long getPendingCount(String status1, String approvalId, InvoiceApproval input) throws Exception {
		// TODO Auto-generated method stub
		return ltInvoiceDao.getPendingCount(status1, approvalId, input);
	}

	@Override
	public ResponseEntity<Status> saveBulkInvoices(InboxBulkInput inboxBulkInput) {
		// TODO Auto-generated method stub
		String apiUrl = lVendorMasterIp + "/lvendormaster/API/invoiceapproval/saveBulkInvoice";
		try {
	        
	        HttpHeaders headers = new HttpHeaders();
	        //headers.set("Authorization", "Bearer " + token); // Added Authorization header
	        headers.set("access_token", inboxBulkInput.getToken());
	        headers.set("Content-Type", "application/json");

	        HttpEntity<InboxBulkInput> entity = new HttpEntity<>(inboxBulkInput, headers); // Added HttpEntity with headers

	        ResponseEntity<Status> response = restTemplate.exchange(
	        		apiUrl,
	                HttpMethod.POST,
	                entity,
	                Status.class // Expect a list of objects
	        );

	        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@Override
	public boolean checkStatusIsPending(Long headerId, Long approvalId,String token) {
		// TODO Auto-generated method stub
		String apiUrl = lVendorMasterIp + "/lvendormaster/API/invoiceheader/checkStatusIsPending/"+headerId+ "/"+approvalId+"/"+currentTimestamp;
		try {
	        // Set up headers with the access token
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("access_token", token);  // Set the access token in the header
	        headers.set("Content-Type", "application/json");

	        // No request body required, so use HttpEntity with just headers
	        HttpEntity<Void> entity = new HttpEntity<>(headers);

	        // Make the API call
	        ResponseEntity<Boolean> response = restTemplate.exchange(
	            apiUrl,
	            HttpMethod.GET,  // Use GET since your URL is structured for a GET request
	            entity,
	            Boolean.class  // Expecting a boolean response
	        );

	        // Return the response body directly (boolean value)
	        return response.getBody() != null && response.getBody();

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;  // Return false if an error occurs
	    }

	}

}
