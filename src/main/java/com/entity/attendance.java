package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
@Entity(name = "coursedetails")
@Getter
@Setter
public class attendance implements Serializable{
	@Id
	private Date time;
	@Column(name = "attend")
	private int check;
	@Id
	@ManyToOne
	@JoinColumn(name = "studentid")
	private User user;
	@Id
	@ManyToOne
	@JoinColumn(name = "courseid")
	private Course course;
	
	
}
