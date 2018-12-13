package com.retry.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retry.service.RetryService;


@RestController
public class RetryRequestHandler {
	
	@Autowired
	private RetryService service;
	
	@RequestMapping(value="/requestone", method=RequestMethod.GET)
	public void handlerOne() {
		Optional<String> op = service.requestOne(1);
		System.out.println(op.isPresent());
		System.out.println(op.get());
	}
	
	@RequestMapping(value="/requesttwo", method=RequestMethod.GET)
	public void handlerTwo() {
		Optional<String> op = service.requestOne(1);
		System.out.println(op.isPresent());
		System.out.println(op.get());
	}

}
