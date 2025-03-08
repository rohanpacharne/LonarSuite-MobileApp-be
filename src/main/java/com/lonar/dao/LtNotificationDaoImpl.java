package com.lonar.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lonar.model.LtMastLogins;
import com.lonar.model.LtMastNotifications;

@Repository
public class LtNotificationDaoImpl implements LtNotificationDao{
	
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
	public List<LtMastNotifications> getAllPendingNotifications() {
		// TODO Auto-generated method stub
		String sqlQuery = "select * from lt_mast_notifications where notification_status = 'SENDING'";
		
		List<LtMastNotifications> list=   jdbcTemplate.query(sqlQuery, new Object[]{}, 
				 new BeanPropertyRowMapper<LtMastNotifications>(LtMastNotifications.class)); 
		
		if(list!=null && !list.isEmpty()) {
			return list;
		}else {
			return null;
		}
	}

	@Override
	public List<LtMastLogins> getAllLoginDetails(Long userId) {
		// TODO Auto-generated method stub
		String sqlQuery = "select * from lt_mast_logins where user_id = ? and status = 'ACTIVE' and (device_type = 'ANDROID' or device_type = 'IOS')";
		
		List<LtMastLogins> list=   jdbcTemplate.query(sqlQuery, new Object[]{userId}, 
				 new BeanPropertyRowMapper<LtMastLogins>(LtMastLogins.class)); 
		
		if(list!=null && !list.isEmpty()) {
			return list;
		}else {
			return null;
		}
	}

	@Override
	public int updateNotificationStatus(Long notificationId,String status) {
		// TODO Auto-generated method stub
		String query = "UPDATE LT_MAST_NOTIFICATIONS SET " + 
				"NOTIFICATION_STATUS = ?  WHERE NOTIFICATION_ID = ? ";
		
		int res=jdbcTemplate.update(query,
				status,notificationId);
		
		return res;
	}
	
	@Override
	public int updateReadFlag(Long id,String module) {
		// TODO Auto-generated method stub
				String query = "UPDATE LT_MAST_NOTIFICATIONS SET " + 
						"READ_FLAG = 'Y'  WHERE HEADER_ID = ? AND MODULE = ? ";
				
				int res=jdbcTemplate.update(query,
						id,module);
				
				return res;
	}


}
