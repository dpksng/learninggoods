package com.learninggoods.dao.impl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.learninggoods.dao.api.UserDao;
import com.learninggoods.dao.entity.User;
import com.learninggoods.services.HConnect;
import com.learninggoods.services.JConnect;

@Transactional
@Repository
@Service
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private HConnect con;
	
	public boolean insert(User user){
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(user);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<User> getAllUser(){
		
		List<User> user= new ArrayList<User>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			user=session.createCriteria(User.class).list();
			t.commit();
			session.close();
			return user;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return user;
		}
	}
	
	public boolean delete(String userId){
		
		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from user_details where USR_EMAIL='"+userId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
		
	}

	public boolean update(User user){
		
		try {
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.update(user);
			t.commit();
			session.close();
			return true;
			
			}catch (Exception e) {
				System.out.println("Exception(ADD): " + e);
				return false;
			}
	}

	public User getUserByEmail(String email){
	
		User user=new User();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from user_details where USR_EMAIL='"+email+"'");
				while(rs.next()){
					user.setId(rs.getString("USR_ID"));
					user.setEmail(rs.getString("USR_EMAIL"));
					user.setName(rs.getString("USR_NME"));
					user.setDob(rs.getString("USR_DOB"));
					user.setGender(rs.getString("USR_GEN"));
					user.setPwd(rs.getString("USR_PWD"));
					user.setQuestion1(rs.getString("USR_SQ_1"));
					user.setAnswer1(rs.getString("USR_A_1"));
					user.setQuestion2(rs.getString("USR_SQ_2"));
					user.setAnswer2(rs.getString("USR_A_2"));
					user.setDate(rs.getString("USR_RG_DTE"));
					user.setTime(rs.getString("USR_RG_TME"));
					user.setConf(rs.getString("USR_CONF"));
				}
				
				return user;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return user;
		}
		
	}
		
		
}
