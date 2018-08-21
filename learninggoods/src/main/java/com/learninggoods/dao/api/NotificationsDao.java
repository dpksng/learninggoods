package com.learninggoods.dao.api;

import java.util.List;

import com.learninggoods.dao.entity.Notifications;

public interface NotificationsDao {
	
	public boolean insert(Notifications note);
	public List<Notifications> getAllNotifications();
	public boolean delete(long noteId);
	public boolean update(Notifications note);
	public Notifications getNotifationById(long id);

}
