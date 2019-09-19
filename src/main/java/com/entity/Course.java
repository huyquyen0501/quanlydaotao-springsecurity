package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "course")
public class Course implements Serializable {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	private Set<attendance> listattend = new HashSet<attendance>();
	private String name;
	private Date startedDate;

	private Date endDate;
	@ManyToOne
	@JoinColumn(name = "idteacher")
	private User user;
	private String detail;
	private int hocphi;
	
	

	

}
