package org.gaval.spring.datajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.gaval.spring.datajpa.model.Rudiment;
import org.gaval.spring.datajpa.repository.RudimentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RudimentController{

	@Autowired
	RudimentRepository rudimentRepository;

	Logger logger = LoggerFactory.getLogger(RudimentController.class);

	@GetMapping("/rudiments")
	public ResponseEntity<List<Rudiment>> getAllRudiments(@RequestParam(required = false) String name){
		try {
			List<Rudiment> rudiments = new ArrayList<Rudiment>();

			if (name == null){	
				rudimentRepository.findAll().forEach(rudiments::add);
			} else {
				rudimentRepository.findByNameContaining(name).forEach(rudiments::add);
			}

			if (rudiments.isEmpty()){
				return new ResponseEntity <> (HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity <> ( rudiments, HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/rudiments")
	public ResponseEntity<Rudiment> createRudiment(@RequestBody Rudiment rudiment){
		try{
			Rudiment _rudiment = rudimentRepository
				.save(new Rudiment(rudiment.getName(), rudiment.getDescription(), false));
			return new ResponseEntity<>(_rudiment, HttpStatus.CREATED);
		} catch( Exception e){
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
}

