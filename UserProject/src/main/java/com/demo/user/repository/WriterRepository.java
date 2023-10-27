package com.demo.user.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.user.model.Writer;



@Repository
public interface WriterRepository extends JpaRepository<Writer, Integer> {

	// code here as needed

	public abstract List<Writer> findByWriterId(Integer writerId);
	
	public abstract List<Writer> findByPhone(Integer phone);
	


}