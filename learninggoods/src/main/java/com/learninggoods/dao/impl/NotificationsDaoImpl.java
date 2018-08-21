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

import com.learninggoods.dao.api.NotificationsDao;
import com.learninggoods.dao.entity.Notifications;
import com.learninggoods.services.HConnect;
import com.learninggoods.services.JConnect;


@Transactional
@Repository
@Service
public class NotificationsDaoImpl implements NotificationsDao{

	@Autowired
	private HConnect con;

	public boolean insert(Notifications note) {
			
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(note);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Notifications> getAllNotifications() {
		
		List<Notifications> note= new ArrayList<Notifications>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			note=session.createCriteria(Notifications.class).list();
			t.commit();
			session.close();
			return note;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return note;
		}
		
	}

	public boolean delete(long noteId) {
		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from notifications where NT_ID='"+noteId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean update(Notifications note) {
		try {
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.update(note);
			t.commit();
			session.close();
			return true;
			
			}catch (Exception e) {
				System.out.println("Exception(ADD): " + e);
				return false;
			}
	}

	public Notifications getNotifationById(long id) {

		Notifications note=new Notifications();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from notifications where NT_ID='"+id+"'");
				while(rs.next()){
					note.setId(rs.getLong("NT_ID"));
					note.setTitle(rs.getString("NT_TITLE"));
					note.setDesc(rs.getString("NT_DESC"));
					note.setUrl(rs.getString("NT_URL"));
					note.setDate(rs.getString("NT_DTE"));
					note.setTime(rs.getString("NT_TME"));
				}
				
				return note;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return note;
		}
	}

}
