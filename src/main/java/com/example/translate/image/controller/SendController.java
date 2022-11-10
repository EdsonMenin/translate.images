package com.example.translate.image.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.translate.image.service.TranslateService;

@Controller
public class SendController {
	
	@Autowired
	private TranslateService translateService;
	
	@PostMapping("/sendNote")
	public ResponseEntity<Object> sendNote( @RequestParam("file") MultipartFile file )
	{
		try {
			return ResponseEntity.ok(
					translateService.calculateInfosProb( file ));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

}
