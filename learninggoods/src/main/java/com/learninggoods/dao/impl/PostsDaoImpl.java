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

import com.learninggoods.dao.api.PostsDao;
import com.learninggoods.dao.entity.Posts;
import com.learninggoods.services.HConnect;
import com.learninggoods.services.JConnect;


@Transactional
@Repository
@Service
public class PostsDaoImpl implements PostsDao{
	
	@Autowired
	private HConnect con;

	public boolean insert(Posts post) {
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(post);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Posts> getAllPosts() {
		
		List<Posts> post= new ArrayList<Posts>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			post=session.createCriteria(Posts.class).list();
			t.commit();
			session.close();
			return post;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return post;
		}
	}

	public boolean delete(long postNo) {
		
		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from posts where P_NO='"+postNo+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
		
	}

	public boolean update(Posts post) {
			
		try {
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.update(post);
			t.commit();
			session.close();
			return true;
			
			}catch (Exception e) {
				System.out.println("Exception(ADD): " + e);
				return false;
			}
		
	}

	public Posts getPostById(long id) {

		Posts post=new Posts();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from posts where P_NO='"+id+"'");
				while(rs.next()){
					post.setId(rs.getLong("P_ID"));
					post.setTitle(rs.getString("P_TITLE"));
					post.setDesc(rs.getString("P_DESC"));
					post.setNumber(rs.getLong("P_NO"));
					post.setPuser(rs.getString("P_P_USR"));
				}
				
				return post;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return post;
		}
		
		
	}

}
