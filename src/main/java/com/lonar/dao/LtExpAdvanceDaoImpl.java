package com.lonar.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lonar.model.CodeMaster;
import com.lonar.model.ExpenseApprovalV;

@Component
@PropertySource(value = "classpath:advanceQueries.properties", ignoreResourceNotFound = true)
public class LtExpAdvanceDaoImpl implements LtExpAdvanceDao,CodeMaster {
	
	@Autowired
	private Environment env;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 

	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate;
	} 

	@Override
	public Long getPendingCount(String status1, String approvalId, ExpenseApprovalV input) throws Exception {
		// TODO Auto-generated method stub
		String query = env.getProperty("getPendingCountAdvance");
		
		String amount=null;
		if(input.getExpenseAmount()!=null)
		{
			amount= "%"+input.getExpenseAmount()+"%";
		}
		String number=null;
		if(input.getExpenseNumber()!=null && !input.getExpenseNumber().equals(""))
		{
			number="%"+input.getExpenseNumber().trim().toUpperCase()+"%";
		}
		String status2=null;
		if(input.getStatus()!=null && !input.getStatus().equals(""))
		{
			status2="%"+input.getStatus().trim().toUpperCase()+"%";
		}
		String initiatorName=null;
		if(input.getInitiatorName()!=null && !input.getInitiatorName().equals(""))
		{
			initiatorName="%"+input.getInitiatorName().trim().toUpperCase()+"%";
		}
		
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] { status1, approvalId,approvalId, number,
						amount,status2,input.getLstDate(),initiatorName}, String.class);
 
		return Long.parseLong(count);
	}

}
