package com.learninggoods.dao.api;

import com.learninggoods.dao.entity.Loggers;

public interface LoggersDao {
	
	public boolean insert(Loggers log);
	public boolean delete(long logId);
}
