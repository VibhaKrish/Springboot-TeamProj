package com.demo.user.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "writer_table")
public class Writer {

	@Id 
	
	@Column(name = "writer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer writerId;

	@Column(name = "writer_name")

	private String writerName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private Integer phone;

	

	public Writer() {
		super();
	}

	public Writer(Integer writerId, String writerName, String email, Integer phone) {
		super();
		this.writerId = writerId;
		this.writerName = writerName;
		this.email = email;
		this.phone = phone;
	}



	public Integer getwriterId() {
		return writerId;
	}

	public void setwriterId(Integer writerId) {
		this.writerId = writerId;
	}

	public String getwriterName() {
		return writerName;
	}

	public void setwriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Writer [writerId=" + writerId + ", writerName=" + writerName + ", email=" + email + ", phone=" + phone
				+ "]";
	}

}

