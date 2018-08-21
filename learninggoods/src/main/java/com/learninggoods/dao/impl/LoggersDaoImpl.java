package com.learninggoods.dao.impl;

import java.sql.Statement;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.learninggoods.dao.api.LoggersDao;
import com.learninggoods.dao.entity.Loggers;
import com.learninggoods.services.HConnect;
import com.learninggoods.services.JConnect;

@Transactional
@Repository
@Service
public class LoggersDaoImpl implements LoggersDao{
	
	@Autowired
	private HConnect con;

	public boolean insert(Loggers log) {
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(log);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
	}

	public boolean delete(long logId) {

		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from loggers where log_id='"+logId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

}
