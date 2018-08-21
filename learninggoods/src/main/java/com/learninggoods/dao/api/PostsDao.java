package com.learninggoods.dao.api;

import java.util.List;


import com.learninggoods.dao.entity.Posts;

public interface PostsDao {
	
	public boolean insert(Posts post);
	public List<Posts> getAllPosts();
	public boolean delete(long postNo);
	public boolean update(Posts post);
	public Posts getPostById(long id);

}
