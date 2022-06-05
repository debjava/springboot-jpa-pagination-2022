package com.ddlab.rnd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.entity.Tutorial;
import com.ddlab.rnd.service.TutorialService;

@Component
public class AutoRun {
	
	@Autowired
	private TutorialService service;

	@EventListener(ApplicationReadyEvent.class)
	public void afterStartup() {
		List<Tutorial> tutorials = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Tutorial tutorial = new Tutorial("Title "+i, "Description "+i);
			tutorials.add(tutorial);
		}
		service.saveAllTutotials(tutorials);
	}
}
