package com.merc.blog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.merc.blog.model.Blog;
import com.merc.blog.service.BlogService;

import jakarta.validation.Valid;


@RestController
public class BlogController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping(path = "get-all-blogs", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Blog>> getAllBlogs() {
		List<Blog> blogList = blogService.getAllBlogs();
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Blog>> response = new ResponseEntity<List<Blog>>(blogList,status);
		LOG.info(Integer.toString(blogList.size()));
		return response;
	}
	
	@RequestMapping(path = "get-blog-by-id/{blogid}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Blog> getEmpById(@PathVariable(name = "blogid") Integer id) {
		Blog blogObj = blogService.getBlogById(id);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Blog found successfully.");
		ResponseEntity<Blog> response = new ResponseEntity<Blog>(blogObj, headers, status);
		LOG.info(blogObj.toString());
		return response;
	}
	
	@RequestMapping(path = "add-blog", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Blog> addEmp(@RequestBody @Valid Blog blog) {
		Blog blogObj = blogService.addBlog(blog);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Blog created successfully.");
		ResponseEntity<Blog> response = new ResponseEntity<Blog>(blogObj, headers, status);
		LOG.info(blogObj.toString());
		return response;
	}
	
	@RequestMapping(path = "update-blog", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Blog> updateEmp(@RequestBody Blog blog) {
		Blog blogObj = blogService.updateBlog(blog);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Blog updated successfully.");
		ResponseEntity<Blog> response = new ResponseEntity<Blog>(blogObj, headers, status);
		LOG.info(blogObj.toString());
		return response;
	}

	@RequestMapping(path = "delete-blog/{blogid}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Blog> deleteEmp(@PathVariable(name = "blogid") Integer id) {
		Blog blogObj = blogService.deleteBlog(id);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Blog deleted successfully.");
		ResponseEntity<Blog> response = new ResponseEntity<Blog>(blogObj, headers, status);
		LOG.info(blogObj.toString());
		return response;
	}
	
	@RequestMapping(path = "get-blog-by-title/{title}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Blog>> getEmpByName(@PathVariable(name = "title") String title) {
		List<Blog> blogList = blogService.getBlogByTitle(title);
		HttpStatus status;
		HttpHeaders headers;
		ResponseEntity<List<Blog>> response;
		if(blogList.size()>0) {
			status = HttpStatus.OK;
			headers = new HttpHeaders();
			headers.add("message", "Blog found successfully.");
			response = new ResponseEntity<List<Blog>>(blogList, headers, status);
			LOG.info(blogList.toString());
		}
		else {
			status = HttpStatus.NOT_FOUND;
			headers = new HttpHeaders();
			headers.add("message", "Blog not found.");
			response = new ResponseEntity<List<Blog>>(blogList, headers, status);
			LOG.info(blogList.toString());
		}
		return response;
	}
	

}
