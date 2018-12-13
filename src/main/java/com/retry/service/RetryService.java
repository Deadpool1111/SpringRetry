package com.retry.service;

import java.util.Optional;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.retry.exception.RetryException;

@Service
public class RetryService {
	
	@Retryable(value = { RetryException.class },  maxAttempts = 2, backoff = @Backoff(delay=1000))
	public Optional<String> requestOne(int value){
		if(value ==1) {
			throw new RetryException();
		}
		return Optional.of(" request one method");
	}
	
	@Retryable(value = { RetryException.class },  maxAttempts = 2, backoff = @Backoff(delay=1000))
	public Optional<Integer> requestTwo(int value){
		if(value ==1) {
			throw new RetryException();
		}
		return Optional.of(1);
	}
	
	@Recover
	public Optional<String> recovery(RetryException ex, int value){
		return Optional.of(" recovery method ");
	}

}
