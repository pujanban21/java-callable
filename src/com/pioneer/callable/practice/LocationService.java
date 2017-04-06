package com.pioneer.callable.practice;

import java.util.concurrent.Callable;

public class LocationService {

	public Callable<String> implLocationService() {
		Callable<String> callableLocationService = new Callable<String>() {

			@Override
			public String call() throws Exception {

				return "Location Service Implemented";
			}
		};
		return callableLocationService;
	}
}
