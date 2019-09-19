package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
 @Getter
@Setter
@Entity(name = "tblposition")
public class Role implements Serializable {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "Name")
	private String name;
	@ManyToMany(mappedBy = "role")
	private Set<User> User;
	
}
