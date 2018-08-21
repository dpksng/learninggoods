package com.learninggoods.dao.api;

import java.util.List;

import com.learninggoods.dao.entity.Tests;

public interface TestsDao {
	
	public boolean insert(Tests test);
	public List<Tests> getAllTests();
	public boolean delete(long testNo);
	public boolean update(Tests test);
	public Tests getTestById(long id);
	public Tests getTestById(String id);
	public List<Tests> getAllTestsBytest(String test);

}
