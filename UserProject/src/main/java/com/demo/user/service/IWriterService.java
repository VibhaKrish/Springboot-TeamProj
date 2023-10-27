package com.demo.user.service;


import java.util.List;

import com.demo.user.model.Writer;



public interface IWriterService {

	public abstract List<Writer> getAllWriters();

	public abstract Writer getwriterById(Integer wid);

	public abstract Writer addWriter(Writer writer);
}