package com.learninggoods.dao.impl;

import javax.transaction.Transactional;


import org.hibernate.Session;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.learninggoods.dao.api.RolesDao;
import com.learninggoods.dao.entity.Roles;
import com.learninggoods.services.HConnect;

@Transactional
@Repository
@Service
public class RolesDaoImpl implements RolesDao{
	
	@Autowired
	private HConnect con;

	public boolean insert(Roles role) {
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(role);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
		
	}

}
