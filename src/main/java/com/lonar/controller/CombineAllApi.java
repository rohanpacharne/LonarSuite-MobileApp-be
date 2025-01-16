package com.lonar.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity; 
import org.springframework.http.HttpHeaders; 
import org.springframework.http.HttpMethod; 
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lonar.dao.LtVendorDao;
import com.lonar.dto.LoginDto;
import com.lonar.dto.LoginResponseDto;
import com.lonar.model.ApproveFeedbackReject;
import com.lonar.model.CodeMaster;
import com.lonar.model.CustomeDataTable;
import com.lonar.model.ExpenseApprovalV;
import com.lonar.model.InboxBulkInput;
import com.lonar.model.InvoiceApproval;
import com.lonar.model.LtExpExpenseHeaders;
import com.lonar.model.LtExpenseApproval;
import com.lonar.model.LtExpenseApprovalHistory;
import com.lonar.model.LtInvoiceHeaders;
import com.lonar.model.LtVendorApproval;
import com.lonar.model.Status;
import com.lonar.model.VendorApproval;
import com.lonar.service.CombineAllApiService;
import com.lonar.service.ExpenseApprovalVservice;
import com.lonar.service.LtExpAdvanceService;
import com.lonar.service.LtInvoiceService;


@RestController
@RequestMapping(value = "/MobileAppApi")
public class CombineAllApi implements CodeMaster {
		
	@Autowired
	CombineAllApiService combineAllApiService;
	
	@Autowired
	ExpenseApprovalVservice expenseApprovalVservice;
	
	@Autowired
	LtExpAdvanceService ltExpAdvanceService;
	
	@Autowired
	LtInvoiceService ltInvoiceService;
	
	@Autowired
	LtVendorDao ltVendorDao;
	
	
	private final RestTemplate restTemplate = new RestTemplate(); 
	
	ExpenseApprovalV parseExpensesResponse(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Parse the "Expenses" string to the ExpensesResponse class
        return objectMapper.readValue(json, ExpenseApprovalV.class);
    }
	
	@RequestMapping(value = "/getAllApprovalInbox", method = RequestMethod.POST)
	public Map<String, Object> getAllApprovalInbox(@RequestBody LoginDto loginDto,@RequestParam Long start, @RequestParam Long length,@RequestParam String dataKey) {		
		System.out.println("in getAllApprovalInbox");
		if("null".equalsIgnoreCase(dataKey)) {
			dataKey = null;
		}
		try {
			Map<String, Object> data = consumeApis(loginDto.getEmpId(), loginDto.getToken(),start,length,dataKey);
         
//			Map<String, Object> renamedData = new HashMap<>();
//            for (Map.Entry<String, Object> entry : data.entrySet()) {
//                String newKey = getDescriptiveKey(entry.getKey()); 
//                renamedData.put(newKey, entry.getValue());
//            }
//			
//			System.out.println("data" +data);
//			renamedData.forEach((key, value) -> {
//              System.out.println("API URL: " + key);
//              System.out.println("Response: " + value);
//              System.out.println("----------------------------");
//          });
          return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
    public Map<String, Object> consumeApis(Long empId, String token,Long start,Long length,String dataKey) throws Exception {
        String loginUrl = "http://174.138.187.142:9095/UserManagement/oauth/mobileLogin";
        String loginPayload = "{\"userName\": \"gajanan@lonartech.com\", \"password\": \"Reset@1234\"}";

        if (token == null || token.isEmpty()) {
          throw new Exception("Failed to retrieve access token");
      }
        
        // Generate current timestamp dynamically // Changed
        long currentTimestamp = System.currentTimeMillis(); // Changed
      
        String[] apiUrls = {
                String.format("http://174.138.187.142:9098/lsuitemasters/API/ExpenseApprovalInbox/dataTable/%d/%d?&draw=1&start="+start+"&length="+length+"&column=0", empId, currentTimestamp),
                String.format("http://174.138.187.142:9097/lvendormaster/API/Inbox/dataTable/%d/%d?&draw=1&start="+start+"&length="+length+"&column=0", empId, currentTimestamp),
                String.format("http://174.138.187.142:9097/lvendormaster/API/Inbox/invoicedataTable/%d/%d?&draw=1&start="+start+"&length="+length+"&column=0", empId, currentTimestamp),
                String.format("http://174.138.187.142:9098/lsuitemasters/API/advance/dataTable/%d/%d?&draw=1&start="+start+"&length="+length+"&column=0", empId, currentTimestamp)
            };

        
        Map<String, Object> responses = new HashMap<>();
                
        ObjectMapper objectMapper = new ObjectMapper();
        
        if(dataKey==null) {
        	
        	System.out.println("in if");
        	
        	for (String apiUrl : apiUrls) {
//              responses.put(apiUrl, makeGetRequest(apiUrl, accessToken));
          	 if (apiUrl.contains("ExpenseApprovalInbox/dataTable")) {
          		 String responseString = makeGetRequest(apiUrl, token);
//               	ExpenseApprovalV expensesResponse = objectMapper.readValue(responseString, ExpenseApprovalV.class);
               	CustomeDataTable expensesResponse = objectMapper.readValue(responseString, CustomeDataTable.class);
               	ExpenseApprovalV expenseApprovalV = new ExpenseApprovalV();
            	Long count = expenseApprovalVservice.getPendingCount(PENDING,empId.toString(),expenseApprovalV);
            	if (count == null) {
            	    count = 0L; // Default value if null
            	}
            	expensesResponse.setPendingCount(count);
                   responses.put(EXPENSE, expensesResponse);
          	 }
          	 else if (apiUrl.contains("Inbox/invoicedataTable")) {
          		 String responseString = makeGetRequest(apiUrl, token);
//               	ExpenseApprovalV expensesResponse = objectMapper.readValue(responseString, ExpenseApprovalV.class);
               	CustomeDataTable expensesResponse = objectMapper.readValue(responseString, CustomeDataTable.class);
               	InvoiceApproval invoiceApproval = new InvoiceApproval();
            	Long count = ltInvoiceService.getPendingCount(PENDING,empId.toString(),invoiceApproval);
            	if (count == null) {
            	    count = 0L; // Default value if null
            	}
            	expensesResponse.setPendingCount(count);
                   responses.put(INVOICE, expensesResponse);
          	 }
          	 else if (apiUrl.contains("Inbox/dataTable")) {
          		 String responseString = makeGetRequest(apiUrl, token);
//               	ExpenseApprovalV expensesResponse = objectMapper.readValue(responseString, ExpenseApprovalV.class);
               	CustomeDataTable expensesResponse = objectMapper.readValue(responseString, CustomeDataTable.class);
               	VendorApproval vendorApproval = new VendorApproval();
            	Long count = ltVendorDao.getPendingCount(PENDING,empId.toString(),vendorApproval);
            	if (count == null) {
            	    count = 0L; // Default value if null
            	}
            	expensesResponse.setPendingCount(count);
                   responses.put(VENDOR, expensesResponse);
          	 }
          	 else if (apiUrl.contains("advance/dataTable")) {
          		 String responseString = makeGetRequest(apiUrl, token);
//               	ExpenseApprovalV expensesResponse = objectMapper.readValue(responseString, ExpenseApprovalV.class);
               	CustomeDataTable expensesResponse = objectMapper.readValue(responseString, CustomeDataTable.class);
               	ExpenseApprovalV expenseApprovalV = new ExpenseApprovalV();
            	Long count = ltExpAdvanceService.getPendingCount(PENDING,empId.toString(),expenseApprovalV);
            	if (count == null) {
            	    count = 0L; // Default value if null
            	}
            	expensesResponse.setPendingCount(count);
                   responses.put(ADVANCE, expensesResponse);
          	 }
          	
    //          responses.put(apiUrl, makeGetRequest(apiUrl, token));
          }
        	
        }else {
        	System.out.println("in else");
        	if(dataKey.equals(EXPENSE)) {
        		String apiUrl = String.format("http://174.138.187.142:9098/lsuitemasters/API/ExpenseApprovalInbox/dataTable/%d/%d?&draw=1&start="+start+"&length="+length+"&column=0", empId, currentTimestamp);
        		String responseString = makeGetRequest(apiUrl, token);
            	CustomeDataTable expensesResponse = objectMapper.readValue(responseString, CustomeDataTable.class);
            	ExpenseApprovalV expenseApprovalV = new ExpenseApprovalV();
            	Long count = expenseApprovalVservice.getPendingCount(PENDING,empId.toString(),expenseApprovalV);
            	if (count == null) {
            	    count = 0L; // Default value if null
            	}
            	expensesResponse.setPendingCount(count);
                responses.put(EXPENSE, expensesResponse);
        	}else if(dataKey.equals(VENDOR)) {
        		String apiUrl = String.format("http://174.138.187.142:9097/lvendormaster/API/Inbox/dataTable/%d/%d?&draw=1&start="+start+"&length="+length+"&column=0", empId, currentTimestamp);
        		String responseString = makeGetRequest(apiUrl, token);
            	CustomeDataTable expensesResponse = objectMapper.readValue(responseString, CustomeDataTable.class);
            	VendorApproval vendorApproval = new VendorApproval();
            	Long count = ltVendorDao.getPendingCount(PENDING,empId.toString(),vendorApproval);
            	if (count == null) {
            	    count = 0L; // Default value if null
            	}
            	expensesResponse.setPendingCount(count);
                responses.put(VENDOR, expensesResponse);
        	}else if(dataKey.equals(INVOICE)) {
        		String apiUrl = String.format("http://174.138.187.142:9097/lvendormaster/API/Inbox/invoicedataTable/%d/%d?&draw=1&start="+start+"&length="+length+"&column=0", empId, currentTimestamp);
        		String responseString = makeGetRequest(apiUrl, token);
            	CustomeDataTable expensesResponse = objectMapper.readValue(responseString, CustomeDataTable.class);
            	InvoiceApproval invoiceApproval = new InvoiceApproval();
            	Long count = ltInvoiceService.getPendingCount(PENDING,empId.toString(),invoiceApproval);
            	if (count == null) {
            	    count = 0L; // Default value if null
            	}
            	expensesResponse.setPendingCount(count);
                responses.put(INVOICE, expensesResponse);
        	}else if(dataKey.equals(ADVANCE)) {
        		String apiUrl = String.format("http://174.138.187.142:9098/lsuitemasters/API/advance/dataTable/%d/%d?&draw=1&start="+start+"&length="+length+"&column=0", empId, currentTimestamp);
        		String responseString = makeGetRequest(apiUrl, token);
            	CustomeDataTable expensesResponse = objectMapper.readValue(responseString, CustomeDataTable.class);
            	ExpenseApprovalV expenseApprovalV = new ExpenseApprovalV();
            	Long count = ltExpAdvanceService.getPendingCount(PENDING,empId.toString(),expenseApprovalV);
            	if (count == null) {
            	    count = 0L; // Default value if null
            	}
            	expensesResponse.setPendingCount(count);
                responses.put(ADVANCE, expensesResponse);
        	}
        	
        }
        
        return responses;
        
    }

    
    private static String getDescriptiveKey(String apiUrl) {
        if (apiUrl.contains("ExpenseApprovalInbox/dataTable")) {
            return EXPENSE;
        } else if (apiUrl.contains("Inbox/invoicedataTable")) {
            return INVOICE;
        } else if (apiUrl.contains("Inbox/dataTable")) {
            return VENDOR;
        } else if (apiUrl.contains("advance/dataTable")) {
            return ADVANCE;
        }
        return apiUrl; // Fallback to the original URL if no match
    }
    
    private static String getAccessToken(String loginUrl, String payload) throws Exception {
        URL url = new URL(loginUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            os.write(payload.getBytes());
            os.flush();
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            // Assuming the token is in the header "access_token"
            return connection.getHeaderField("access_token");
        }

        return null;
    }

    private static String makeGetRequest(String apiUrl, String accessToken) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("access_token", accessToken);

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            return response.toString();
        }

        throw new Exception("GET request failed for URL: " + apiUrl + " with response code: " + responseCode);
    }
       
    
    @RequestMapping(value = "/mobileLogin", method = RequestMethod.POST)
    public ResponseEntity<?> mobileLogin(@RequestBody Map<String, String> loginRequest,HttpServletResponse response) {
    	return combineAllApiService.mobileLogin(loginRequest,response);
    }
  

    @PostMapping("/expenseHeaderById")
    public LtExpExpenseHeaders getExpenseHeader(@RequestBody LtExpExpenseHeaders ltExpExpenseHeaders) {
        return combineAllApiService.getExpenseHeaderById(ltExpExpenseHeaders.getExpHeaderId(), ltExpExpenseHeaders.getToken());
}
    
    @PostMapping("/getApprovalHistoryByExpensehederId")
    public List<LtExpenseApprovalHistory> getApprovalHistoryByExpensehederId(@RequestBody LtExpExpenseHeaders ltExpExpenseHeaders) {
    	return combineAllApiService.getApprovalHistoryByExpensehederId(ltExpExpenseHeaders.getExpHeaderId(),ltExpExpenseHeaders.getToken());
    }
    
    @PostMapping("/expenseApprovalByHeaderId")
    public List<LtExpenseApproval> getApprovalByHeaderId(@RequestBody LtExpExpenseHeaders ltExpExpenseHeaders) {
        return combineAllApiService.getApprovalByHeaderId(ltExpExpenseHeaders.getExpHeaderId(), ltExpExpenseHeaders.getToken());
	}
    
    
    @PostMapping("/approved")
    public Status approveFeedbackReject(@RequestBody ApproveFeedbackReject approveFeedbackReject) {
    	return combineAllApiService.approveFeedbackReject(approveFeedbackReject);
    }
    
    @RequestMapping(value = "/dataTable/{approvalId}/{logTime}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomeDataTable getExpenseApprovalVDataTableByExpHeaderId(@Valid ExpenseApprovalV input,
			@PathVariable("approvalId") String approvalId,@PathVariable("logTime") String logTime)
	{
		String status1= PENDING ;
		CustomeDataTable customeDataTable = new CustomeDataTable();
		try  {
				Long count=expenseApprovalVservice.getCount(status1, approvalId,input);
				
			    customeDataTable.setRecordsTotal(count);
			    customeDataTable.setRecordsFiltered(count);
			    
				List<ExpenseApprovalV> expenseApprovalList= expenseApprovalVservice.getByStatus(status1, approvalId,input);
			    //List<ExpenseApprovalV> expenseApprovalList = new ArrayList<>();
				customeDataTable.setData(expenseApprovalList);
			
		}
		catch (Exception e)
		{
//			throw new BusinessException(0, null, e);
			System.out.println(e.getMessage());
		}
		return customeDataTable;
	}
    
    @PostMapping("/saveBulkExpenses")
    public ResponseEntity<Status> saveBulkExpenses(@RequestBody InboxBulkInput inboxBulkInput) {
    	return combineAllApiService.saveBulkExpenses(inboxBulkInput);
    }
}