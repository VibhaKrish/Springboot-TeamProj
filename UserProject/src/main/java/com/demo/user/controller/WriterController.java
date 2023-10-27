package com.demo.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.model.Writer;
import com.demo.user.service.WriterService;


@RestController
@RequestMapping("api")

@CrossOrigin(origins = "*")
public class WriterController{

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	WriterService writerService;

//	http://localhost:8090/api/get-all-writers

	@GetMapping("get-all-writers")
	public ResponseEntity<List<Writer>> getAllwriters() {
		List<Writer> writerList = writerService.getAllWriters();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Writers found successfully.");
		ResponseEntity<List<Writer>> response = new ResponseEntity<List<Writer>>(writerList, headers, status);
		LOG.info(Integer.toString(writerList.size()));
		return response;
	}

	@GetMapping("get-writer-by-id/{writer_id}")
	public ResponseEntity<Writer> getwriterById(@PathVariable(name = "writer_id") Integer writerId) {
		Writer writerObj = writerService.getwriterById(writerId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Writer found successfully.");
		ResponseEntity<Writer> response = new ResponseEntity<Writer>(writerObj, headers, status);
		LOG.info(writerObj.toString());
		return response;
	}

	@PostMapping("add-writer")
	public ResponseEntity<Writer> addwriter(@RequestBody Writer writer) {
		Writer writerObj = writerService.addWriter(writer);
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Writer created successfully.");
		ResponseEntity<Writer> response = new ResponseEntity<Writer>(writerObj, headers, status);
		LOG.info(writerObj.toString());
		return response;
	}

}
