package com.learninggoods.dao.impl;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.learninggoods.dao.api.AdminDao;
import com.learninggoods.dao.entity.Admin;
import com.learninggoods.services.HConnect;
import com.learninggoods.services.JConnect;


@Transactional
@Repository
@Service
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private HConnect con;

	public boolean insert(Admin admin) {

		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(admin);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
		
	}

	public Admin getAdminById(String adminId) {

		Admin admin=new Admin();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from admin_details where ADMN_ID='"+adminId+"'");
				while(rs.next()){
					admin.setId(rs.getString("ADMN_ID"));
					admin.setName(rs.getString("ADMN_NME"));
					admin.setGender(rs.getString("ADMN_GEN"));
					admin.setPwd(rs.getString("ADMN_PWD"));
					
				}
				
				return admin;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return admin;
		}
		
	}

}
