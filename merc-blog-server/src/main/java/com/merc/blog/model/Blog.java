package com.merc.blog.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blog_table")
public class Blog {
	
	@Id // indicated PK column field
	@Column(name = "blog_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "blog_title")
	@Length(min = 3, max = 20, message = "length should be 4 to 20 characters!")
	private String title;
	
	@Column(name = "blog_body")
	private String body;

	public Blog() {
		super();
	}

	public Blog(Integer id, @Length(min = 3, max = 20, message = "length should be 4 to 20 characters!") String title,
			String body) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", body=" + body + "]";
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	

}
