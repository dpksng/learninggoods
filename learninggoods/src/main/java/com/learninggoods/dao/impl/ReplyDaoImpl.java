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

import com.learninggoods.dao.api.ReplyDao;
import com.learninggoods.dao.entity.Reply;
import com.learninggoods.services.HConnect;
import com.learninggoods.services.JConnect;


@Transactional
@Repository
@Service
public class ReplyDaoImpl implements ReplyDao{

	@Autowired
	private HConnect con;

	public boolean insert(Reply reply) {
			
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(reply);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Reply> getAllReply() {
		
		List<Reply> reply= new ArrayList<Reply>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			reply=session.createCriteria(Reply.class).list();
			t.commit();
			session.close();
			return reply;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return reply;
		}
		
	}

	public boolean delete(long replyId) {
		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from reply where R_ID='"+replyId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean update(Reply reply) {
		try {
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.update(reply);
			t.commit();
			session.close();
			return true;
			
			}catch (Exception e) {
				System.out.println("Exception(ADD): " + e);
				return false;
			}
	}

	public Reply getReplyById(long id) {

		Reply reply=new Reply();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from reply where R_ID='"+id+"'");
				while(rs.next()){
					reply.setNumber(rs.getLong("R_ID"));
					reply.setId(rs.getLong("P_ID"));
					reply.setReply(rs.getString("P_REPLY"));
					reply.setPuser(rs.getString("P_P_USR"));
					reply.setRuser(rs.getString("P_R_USR"));
				}
				
				return reply;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return reply;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Reply> getAllReplyByPost(Long postId) {
		
		List<Reply> reply= new ArrayList<Reply>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			@SuppressWarnings("deprecation")
			Criteria cr=session.createCriteria(Reply.class);
			cr.add(Restrictions.eq("id",postId));
			reply=cr.list();
			t.commit();
			session.close();
			return reply;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return reply;
		}
	}

}
