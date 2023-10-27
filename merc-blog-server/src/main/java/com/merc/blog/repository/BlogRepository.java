package com.merc.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.merc.blog.model.Blog;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	public abstract List<Blog> findByTitleIgnoreCase(String title);

}
