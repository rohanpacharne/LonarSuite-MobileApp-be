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

import com.lonar.dao.LtVendorDao;
import com.lonar.model.ApproveFeedbackReject;
import com.lonar.model.CodeMaster;
import com.lonar.model.InboxBulkInput;
import com.lonar.model.LtInvoiceHeaders;
import com.lonar.model.LtMastVendors;
import com.lonar.model.LtVendorApproval;
import com.lonar.model.Status;
import com.lonar.model.VendorApproval;

@Service
public class LtVendorServiceImpl implements LtVendorService,CodeMaster {
	
	@Autowired
	LtVendorDao ltVendorDao;
	
	private final RestTemplate restTemplate = new RestTemplate();
	long currentTimestamp = System.currentTimeMillis();

	@Override
	public LtMastVendors getVendorByVendorId(Long vendorId, String token) {
		String apiUrl = lVendorMasterIp + "/lvendormaster/API/vendor/getvendorbyid/"
                + vendorId + "/" + currentTimestamp;		
		try {
	        
	        HttpHeaders headers = new HttpHeaders();
	        //headers.set("Authorization", "Bearer " + token); // Added Authorization header
	        headers.set("access_token", token);
	        headers.set("Content-Type", "application/json");

	        HttpEntity<String> entity = new HttpEntity<>(headers); // Added HttpEntity with headers

	        ResponseEntity<LtMastVendors> response = restTemplate.exchange(
	                apiUrl,
	                HttpMethod.GET, 
	                entity,
	                LtMastVendors.class
	        );

	        return response.getBody(); 
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch expense header: " + e.getMessage());
	    }
	}

	@Override
	public Long getPendingCount(String status1, String approvalId, VendorApproval input) throws Exception {
		// TODO Auto-generated method stub
		return ltVendorDao.getPendingCount(status1, approvalId, input);
	}

	@Override
	public List<LtVendorApproval> getVendorApprovalByVendorId(Long vendorId, String token) {
		// TODO Auto-generated method stub
		String apiUrl = lVendorMasterIp + "/lvendormaster/API/approval/getApprovalByVendorId/"+
				vendorId+ "/"+currentTimestamp ;
		
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
	        
	        return response.getBody();

	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch expense header: " + e.getMessage());
	    }
	}

	@Override
	public Status approveFeedbackReject(ApproveFeedbackReject approveFeedbackReject) {
		// TODO Auto-generated method stub
		String apiUrl = lVendorMasterIp + "/lvendormaster/API/approval/updateStatusApproval";
        
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
	public ResponseEntity<Status> saveBulkVendors(InboxBulkInput inboxBulkInput) {
		// TODO Auto-generated method stub
		String apiUrl = lVendorMasterIp + "/lvendormaster/API/Inbox/saveBulk";
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

}
