package com.lonar.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.lonar.dto.LoginResponseDto;
import com.lonar.model.ApproveFeedbackReject;
import com.lonar.model.InboxBulkInput;
import com.lonar.model.LtExpExpenseHeaders;
import com.lonar.model.LtExpenseApproval;
import com.lonar.model.LtExpenseApprovalHistory;
import com.lonar.model.LtVendorApproval;
import com.lonar.model.Status;

public interface CombineAllApiService {

	LoginResponseDto login(String userName, String password);

	ResponseEntity<LtExpExpenseHeaders> getExpenseHeaderById(Long long1, Long approvalId, String token);

	List<LtExpenseApprovalHistory> getApprovalHistoryByExpensehederId(Long headerId, String token);
	
	List<LtExpenseApproval> getApprovalByHeaderId(Long headerId, String token);

	Status approveFeedbackReject(ApproveFeedbackReject approveFeedbackReject);
	
	ResponseEntity<?> mobileLogin(@RequestBody Map<String, String> loginRequest,HttpServletResponse response);
	
	public ResponseEntity<Status> saveBulkExpenses(@RequestBody InboxBulkInput inboxBulkInput);
	
	public boolean checkStatusIsPending(Long long1, Long approvalId, String token);

}
