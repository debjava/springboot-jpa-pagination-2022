package com.ddlab.rnd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ddlab.rnd.entity.PageTutorials;
import com.ddlab.rnd.entity.Tutorial;
import com.ddlab.rnd.repository.PaginatedRepo;
import com.ddlab.rnd.service.TutorialService;

@Service
public class TutorialServiceImpl implements TutorialService {

	@Autowired
	private PaginatedRepo repo;

	@Override
	public void saveAllTutotials(List<Tutorial> tutorials) {
		repo.saveAll(tutorials);
	}

	@Override
	public PageTutorials getAllTutorialsByPage(int page, int size) {
		PageTutorials pagedTutorials = new PageTutorials();
		Pageable pageable = PageRequest.of(page, size);
		Page<Tutorial> pageTutorial = repo.findAll(pageable);
		long totalNoOfData = pageTutorial.getTotalElements();
		pagedTutorials.setTotalElements(totalNoOfData);
		if (pageTutorial.hasContent()) {
			pagedTutorials.setTutorials(pageTutorial.getContent());
		}
		return pagedTutorials;
	}
	
	@Override
	public PageTutorials getAllTutorialsByTitlePage(String title, int page, int size) {
		PageTutorials pagedTutorials = new PageTutorials();
		Pageable pageable = PageRequest.of(page, size);
//		Pageable pageable = PageRequest.of(page, size, Sort.DEFAULT_DIRECTION, "title");
//		Page<Tutorial> pageTutorial = repo.findByTitle(title, pageable);
		Page<Tutorial> pageTutorial = repo.findByTitle(title, pageable);
		long totalNoOfData = pageTutorial.getTotalElements();
		pagedTutorials.setTotalElements(totalNoOfData);
		if (pageTutorial.hasContent()) {
			pagedTutorials.setTutorials(pageTutorial.getContent());
		}
		return pagedTutorials;
	}
	
}
