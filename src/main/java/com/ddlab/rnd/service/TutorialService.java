package com.ddlab.rnd.service;

import java.util.List;

import com.ddlab.rnd.entity.PageTutorials;
import com.ddlab.rnd.entity.Tutorial;

public interface TutorialService {

	void saveAllTutotials(List<Tutorial> tutorials);
	
	PageTutorials getAllTutorialsByPage(int page, int size);
	
	PageTutorials getAllTutorialsByTitlePage(String title, int page, int size);
}
