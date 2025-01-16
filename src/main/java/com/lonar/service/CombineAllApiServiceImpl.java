package com.lonar.service;

import org.springframework.stereotype.Service;

import com.lonar.dto.LoginResponseDto;
import com.lonar.model.ApproveFeedbackReject;
import com.lonar.model.CodeMaster;
import com.lonar.model.InboxBulkInput;
import com.lonar.model.LtExpExpenseHeaders;
import com.lonar.model.LtExpenseApproval;
import com.lonar.model.LtExpenseApprovalHistory;
import com.lonar.model.LtVendorApproval;
import com.lonar.model.Status;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity; 
import org.springframework.http.HttpHeaders; 
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class CombineAllApiServiceImpl implements CombineAllApiService,CodeMaster{

	private final RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public LoginResponseDto login(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	long currentTimestamp = System.currentTimeMillis();
	
	@Override
	public LtExpExpenseHeaders getExpenseHeaderById(Long headerId, String token) {
		String apiUrl = "http://174.138.187.142:9098/lsuitemasters/API//expExpense/getExpenseHeaderByHeaderId/"
                + headerId + "/" + currentTimestamp;		
		try {
	        
	        HttpHeaders headers = new HttpHeaders();
	        //headers.set("Authorization", "Bearer " + token); // Added Authorization header
	        headers.set("access_token", token);
	        headers.set("Content-Type", "application/json");

	        HttpEntity<String> entity = new HttpEntity<>(headers); // Added HttpEntity with headers

	        ResponseEntity<LtExpExpenseHeaders> response = restTemplate.exchange(
	                apiUrl,
	                HttpMethod.GET, 
	                entity,
	                LtExpExpenseHeaders.class
	        );

	        return response.getBody(); 
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch expense header: " + e.getMessage());
	    }
		
	}

	@Override
	public List<LtExpenseApprovalHistory> getApprovalHistoryByExpensehederId(Long headerId, String token) {

		String url = "http://174.138.187.142:9098/lsuitemasters/API//ExpenseApprovalHistory/getApprovalHistoryByExpensehederId/"+
				headerId+ "/"+currentTimestamp ;
		try {
	        
	        HttpHeaders headers = new HttpHeaders();
	        //headers.set("Authorization", "Bearer " + token); // Added Authorization header
	        headers.set("access_token", token);
	        headers.set("Content-Type", "application/json");

	        HttpEntity<String> entity = new HttpEntity<>(headers); // Added HttpEntity with headers

	        ResponseEntity<List<LtExpenseApprovalHistory>> response = restTemplate.exchange(
	                url,
	                HttpMethod.GET,
	                entity,
	                new ParameterizedTypeReference<List<LtExpenseApprovalHistory>>() {} // Expect a list of objects
	        );


	        return (List<LtExpenseApprovalHistory>) response.getBody(); 
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch expense header: " + e.getMessage());
	    }
	
	}

	@Override
	public Status approveFeedbackReject(ApproveFeedbackReject approveFeedbackReject) {

		Long empId = approveFeedbackReject.getEmployeeId();
		Long exAppId = approveFeedbackReject.getExpenseApprovalId();
		Long exHeadId = approveFeedbackReject.getExpenseHeaderId();
		String status = approveFeedbackReject.getStatus();
		String remark = approveFeedbackReject.getRemark();
		
		String url ="http://174.138.187.142:9098/lsuitemasters/API//ExpenseApproval/updateStatusApproval";
		//String url = "http://174.138.187.142:9098/lsuitemasters/API//ExpenseApproval/updateStatusApproval";
		//+empId+exAppId+exHeadId+status+remark;
           
		     try {
	        
	        HttpHeaders headers = new HttpHeaders();
	        //headers.set("Authorization", "Bearer " + token); // Added Authorization header
	        headers.set("access_token", approveFeedbackReject.getToken());
	        headers.set("Content-Type", "application/json");

	        HttpEntity<Object> entity = new HttpEntity<>(approveFeedbackReject,headers); // Added HttpEntity with headers
	        ResponseEntity<Status> response = restTemplate.exchange(
	                url,
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
	public ResponseEntity<?> mobileLogin(Map<String, String> loginRequest,HttpServletResponse response1) {
		 String loginApi = userMangementIp + "/UserManagement/oauth/mobileLogin";

	        try {
	            
	            HttpHeaders headers = new HttpHeaders();
	            headers.set("Content-Type", "application/json");
	       
	            HttpEntity<Map<String, String>> entity = new HttpEntity<>(loginRequest, headers); 

	            ResponseEntity<Map> response = restTemplate.exchange(
	            		loginApi,
	                    HttpMethod.POST, 
	                    entity,
	                    Map.class
	            );
	            
	            String accessToken = response.getHeaders().getFirst("access_token");

	            if (accessToken == null) {
	                // Handle case where access token is not found in the response headers
	                Map<String, String> errorResponse = new HashMap<>();
	                errorResponse.put("error", "Access token not found in response headers");
	                return ResponseEntity.status(400).body(errorResponse); // Bad request error
	            }
	            response1.setHeader("access_token", accessToken);
	            return ResponseEntity.ok(response.getBody());
	        } catch (Exception e) {
        
	        	Map<String, String> errorResponse = new HashMap<>();
	        	errorResponse.put("error", "Failed to fetch data from external API");
	        	errorResponse.put("details", e.getMessage());
	        	return ResponseEntity.status(500).body(errorResponse);
	        }	
	}

	@Override
	public List<LtExpenseApproval> getApprovalByHeaderId(Long headerId, String token) {
		
		String apiUrl = lSuiteMastersIp + "/lsuitemasters/API//ExpenseApproval/getApprovalByExpensehederId/"+
				headerId+ "/"+currentTimestamp ;
		try {
	        
	        HttpHeaders headers = new HttpHeaders();
	        //headers.set("Authorization", "Bearer " + token); // Added Authorization header
	        headers.set("access_token", token);
	        headers.set("Content-Type", "application/json");

	        HttpEntity<String> entity = new HttpEntity<>(headers); // Added HttpEntity with headers

	        ResponseEntity<List<LtExpenseApproval>> response = restTemplate.exchange(
	        		apiUrl,
	                HttpMethod.GET,
	                entity,
	                new ParameterizedTypeReference<List<LtExpenseApproval>>() {} // Expect a list of objects
	        );

	        return response.getBody(); 
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch expense header: " + e.getMessage());
	    }
	}

	@Override
	public ResponseEntity<Status> saveBulkExpenses(InboxBulkInput inboxBulkInput) {
		// TODO Auto-generated method stub
		String apiUrl = lSuiteMastersIp + "/lsuitemasters/API/ExpenseApprovalInbox/saveBulk";
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
