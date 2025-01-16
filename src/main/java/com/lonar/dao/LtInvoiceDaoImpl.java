package com.lonar.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.model.CodeMaster;
import com.lonar.model.InvoiceApproval;
import com.lonar.model.VendorApproval;

@Repository
@PropertySource(value = "classpath:invoiceQueries.properties", ignoreResourceNotFound = true)
public class LtInvoiceDaoImpl implements LtInvoiceDao,CodeMaster {
	
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
	public Long getPendingCount(String status1, String approvalId, InvoiceApproval input) throws Exception {
		// TODO Auto-generated method stub
		String query = env.getProperty("getPendingCountInvoice");
		
		

		String invoiceNum=null;
		if(input.getInvoiceNum()!=null && !input.getInvoiceNum().equals(""))
		{
			invoiceNum="%"+input.getInvoiceNum().trim().toUpperCase()+"%";
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
		}else {
			initiatorName="%"+"%";
		}
		
		String count  = (String)getJdbcTemplate().queryForObject(
				query, new Object[] { status1, approvalId,approvalId,status2, invoiceNum,
						  initiatorName}, String.class);

		return Long.parseLong(count);
	}

}
