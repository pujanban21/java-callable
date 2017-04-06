package com.pioneer.callable.practice;

import java.util.concurrent.Callable;

public class WeatherService {

	public Callable<String> implWeatherSerivice() {
		Callable<String> callableWeatherService = new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Weather Service Implemented";
			}
		};
		return callableWeatherService;
	}
}
