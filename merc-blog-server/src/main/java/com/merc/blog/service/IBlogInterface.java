package com.merc.blog.service;

import java.util.List;

import com.merc.blog.model.Blog;

public interface IBlogInterface {
	
	public abstract List<Blog> getAllBlogs();
	
	public abstract Blog getBlogById(Integer id);
	
	public abstract Blog addBlog(Blog b);
	
	public abstract Blog updateBlog(Blog blog);
	
	public abstract List<Blog> getBlogByTitle(String title);

	public abstract Blog deleteBlog(Integer id);

}
