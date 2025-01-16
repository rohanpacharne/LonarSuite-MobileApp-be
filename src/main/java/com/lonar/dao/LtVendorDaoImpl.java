package com.lonar.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.model.ApproveFeedbackReject;
import com.lonar.model.CodeMaster;
import com.lonar.model.Status;
import com.lonar.model.VendorApproval;

@Repository
@PropertySource(value = "classpath:vendorQueries.properties", ignoreResourceNotFound = true)
public class LtVendorDaoImpl implements LtVendorDao,CodeMaster {

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
	public Long getPendingCount(String status1, String approvalId, VendorApproval input) throws Exception {
		String query = env.getProperty("getPendingCountVendor");
		
		
		String vendorName=null;
		if(input.getVendorName()!=null && !input.getVendorName().equals(""))
		{
			vendorName="%"+input.getVendorName().trim().toUpperCase()+"%";
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
				query, new Object[] { status1, approvalId,approvalId, vendorName,
						initiatorName,status2}, String.class);

		return Long.parseLong(count);
	}

}
