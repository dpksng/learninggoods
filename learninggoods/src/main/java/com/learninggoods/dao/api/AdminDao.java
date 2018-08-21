package com.learninggoods.dao.api;

import com.learninggoods.dao.entity.Admin;

public interface AdminDao {

	public boolean insert(Admin admin);
	public Admin getAdminById(String adminId);

}
