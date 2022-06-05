package com.ddlab.rnd.entity;

import java.util.List;

import lombok.Data;

@Data
public class PageTutorials {
	
	private long totalElements;
	private List<Tutorial> tutorials;

}
