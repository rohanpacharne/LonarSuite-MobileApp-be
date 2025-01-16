package com.lonar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lonar.dao.LtExpAdvanceDao;
import com.lonar.model.ExpenseApprovalV;

@Service
public class LtExpAdvanceServiceImpl implements LtExpAdvanceService {

	@Autowired
	LtExpAdvanceDao ltExpAdvanceDao;
	
	@Transactional
	@Override
	public Long getPendingCount(String status1, String approvalId, ExpenseApprovalV input) throws Exception
	{
		return ltExpAdvanceDao.getPendingCount(status1,approvalId,input);
	}

}
