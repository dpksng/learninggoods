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

import com.learninggoods.dao.api.CourseDao;
import com.learninggoods.dao.entity.Course;
import com.learninggoods.services.HConnect;
import com.learninggoods.services.JConnect;


@Transactional
@Repository
@Service
public class CourseDaoImpl implements CourseDao{

	@Autowired
	private HConnect con;
	
	public boolean insert(Course course) {
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(course);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Course> getAllCourse() {
		
		List<Course> course= new ArrayList<Course>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			course=session.createCriteria(Course.class).list();
			t.commit();
			session.close();
			return course;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return course;
		}
	}

	public boolean delete(long courseId) {
		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from courses where CRS_ID='"+courseId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean update(Course course) {

		try {
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.update(course);
			t.commit();
			session.close();
			return true;
			
			}catch (Exception e) {
				System.out.println("Exception(ADD): " + e);
				return false;
			}
	}

	public Course getCourseById(long id) {

		
		Course course=new Course();
		
		try {
				Statement st=JConnect.getStatement();
				ResultSet rs=st.executeQuery("select * from courses where CRS_ID='"+id+"'");
				while(rs.next()){
					course.setId(rs.getLong("CRS_ID"));
					course.setTitle(rs.getString("USR_TITLE"));
					course.setDesc(rs.getString("USR_DESC"));
					course.setUrl(rs.getString("USR_URL"));
				}
				
				return course;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return course;
		}
		
	}

}

