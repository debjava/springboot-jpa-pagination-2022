package com.ddlab.rnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ddlab.rnd.entity.PageTutorials;
import com.ddlab.rnd.service.TutorialService;

@RestController
public class SampleController {

	@Autowired
	private TutorialService service;

	@GetMapping("/tutorials")
	public ResponseEntity<PageTutorials> getAllTutorialsPage(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		PageTutorials pagedTurials = service.getAllTutorialsByPage(page, size);
		return new ResponseEntity<PageTutorials>(pagedTurials, HttpStatus.OK);
	}

	@GetMapping("/tutorials/tile")
	public ResponseEntity<PageTutorials> getAllTutorialsByTitlePage(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		PageTutorials pagedTurials = service.getAllTutorialsByTitlePage(title, page, size);
		return new ResponseEntity<PageTutorials>(pagedTurials, HttpStatus.OK);
	}
}
