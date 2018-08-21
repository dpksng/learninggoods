package com.learninggoods.dao.impl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.learninggoods.dao.api.TestsDao;
import com.learninggoods.dao.entity.Tests;
import com.learninggoods.services.HConnect;
import com.learninggoods.services.JConnect;


@Transactional
@Repository
@Service
public class TestsDaoImpl implements TestsDao{
	
	@Autowired
	private HConnect con;

	public boolean insert(Tests test) {
			
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(test);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Tests> getAllTests() {
		
		List<Tests> test= new ArrayList<Tests>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			test=session.createCriteria(Tests.class).list();
			t.commit();
			session.close();
			return test;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return test;
		}
		
	}

	public boolean delete(long testNo) {
		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from tests where T_NO='"+testNo+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean update(Tests test) {
		try {
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.update(test);
			t.commit();
			session.close();
			return true;
			
			}catch (Exception e) {
				System.out.println("Exception(ADD): " + e);
				return false;
			}
	}

	public Tests getTestById(long id) {

		Tests test=new Tests();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from tests where T_NO='"+id+"'");
				while(rs.next()){
					test.setId(rs.getString("T_ID"));
					test.setNumber(rs.getLong("T_NO"));
					test.setQuestion(rs.getString("T_QUES"));
					test.setAnswer(rs.getString("T_ANS"));
					test.setOption1(rs.getString("OPTION_1"));
					test.setOption2(rs.getString("OPTION_2"));
					test.setOption3(rs.getString("OPTION_3"));
					test.setOption4(rs.getString("OPTION_4"));
				}
				
				return test;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return test;
		}
		
	}
	
	public Tests getTestById(String id){

		Tests test=new Tests();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from tests where T_ID='"+id+"'");
				while(rs.next()){
					test.setId(rs.getString("T_ID"));
					test.setNumber(rs.getLong("T_NO"));
					test.setQuestion(rs.getString("T_QUES"));
					test.setAnswer(rs.getString("T_ANS"));
					test.setOption1(rs.getString("OPTION_1"));
					test.setOption2(rs.getString("OPTION_2"));
					test.setOption3(rs.getString("OPTION_3"));
					test.setOption4(rs.getString("OPTION_4"));
				}
				
				return test;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return test;
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<Tests> getAllTestsBytest(String test) {
		
		List<Tests> tests= new ArrayList<Tests>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			@SuppressWarnings("deprecation")
			Criteria cr=session.createCriteria(Tests.class);
			cr.add(Restrictions.eq("id",test));
			tests=cr.list();
			t.commit();
			session.close();
			return tests;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return tests;
		}
	}
	

}
