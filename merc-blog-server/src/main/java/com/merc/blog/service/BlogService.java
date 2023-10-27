package com.merc.blog.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merc.blog.exception.BlogNotFoundException;
import com.merc.blog.model.Blog;
import com.merc.blog.repository.BlogRepository;


@Service
public class BlogService implements IBlogInterface{
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BlogRepository blogRepo;
	
	@Override
	public List<Blog> getAllBlogs() {
		LOG.info("getAllEmployees");
		return blogRepo.findAll();
	}
	
	@Override
	public Blog getBlogById(Integer id) {
		LOG.info(id.toString());
		Optional<Blog> blogOpt=blogRepo.findById(id);
		if(blogOpt.isPresent()) {
			return blogOpt.get();
		}else {
			String errorMessage="Blog with id "+id+" not found";
			LOG.warn(errorMessage);
			throw new BlogNotFoundException(errorMessage);
		}
	}
	
	@Override
	public Blog addBlog(Blog b) {
		LOG.info(b.toString());
		return blogRepo.save(b);
	}
	
	@Override
	public Blog deleteBlog(Integer id) {
		LOG.info(id.toString());
		Optional<Blog> blogOpt=blogRepo.findById(id);
		blogRepo.deleteById(id);
		if(blogOpt.isPresent()) {
			return blogOpt.get();
		}
		return null;
	}
	
	@Override
	public Blog updateBlog(Blog blog) {
		LOG.info(blog.toString());
		return blogRepo.save(blog);
	}
	
	@Override
	public List<Blog> getBlogByTitle(String title) {
		LOG.info(title);
		return blogRepo.findByTitleIgnoreCase(title);
	}
}
