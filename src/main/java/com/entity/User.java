package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<attendance> listattend = new HashSet<attendance>();
	@Column(name = "name")
	private String name;
	@Column(name = "sex")
	private int sex;
	@Column(name = "address")
	private String addess;
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> role;
	@Column(name = "Company")
	private int company;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String passWord;
	@Column(name = "idPosition")
	private int idPosition;
	private String passWordConfirm;

}
