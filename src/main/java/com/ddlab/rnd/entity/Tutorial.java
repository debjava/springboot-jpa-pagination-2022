package com.ddlab.rnd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "Tutorial")
@Table(name = "tutorials")
@Getter
@Setter
public class Tutorial {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	public Tutorial() {

	}

	public Tutorial(String title, String description) {
		this.title = title;
		this.description = description;
	}
}