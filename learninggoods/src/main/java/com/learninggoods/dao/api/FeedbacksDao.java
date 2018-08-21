package com.learninggoods.dao.api;

import java.util.List;

import com.learninggoods.dao.entity.Feedbacks;

public interface FeedbacksDao{
	
	public boolean insert(Feedbacks feed);
	public List<Feedbacks> getAllFeedbacks();
	public boolean delete(long feedId);
}
