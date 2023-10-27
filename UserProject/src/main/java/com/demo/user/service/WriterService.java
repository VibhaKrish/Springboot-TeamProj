package com.demo.user.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.user.exception.WriterNotFoundException;
import com.demo.user.model.Writer;
import com.demo.user.repository.WriterRepository;


@Service
public class WriterService implements IWriterService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	WriterRepository writerRepository;

	@Override
	public List<Writer> getAllWriters() {
		LOG.info("getAllWriters");
		return writerRepository.findAll();
	}

	@Override
	public Writer addWriter(Writer writer) {
		LOG.info(writer.toString());
		return writerRepository.save(writer);
	}

	@Override
	public Writer getwriterById(Integer wid) {
		// TODO Auto-generated method stub
		Optional<Writer> writerOpt = writerRepository.findById(wid);
		if(writerOpt.isPresent()) {
			return writerOpt.get();
		}else {
			String errMessage = "Writer with " + wid + " not found!";
			throw new WriterNotFoundException(errMessage);
		}
	}
}