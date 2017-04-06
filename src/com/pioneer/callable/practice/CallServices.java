package com.pioneer.callable.practice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallServices {

//	private Map<String, Callable<String>> listOfServices;
	private Set<Callable<String>> setOfServices;
	private List<Future<String>> getValuesFromServices;

	private ExecutorService executor = Executors.newWorkStealingPool();

	public Set<Callable<String>> appendServices() {
		setOfServices = new HashSet<>();
		setOfServices.add(new WeatherService().implWeatherSerivice());
		setOfServices.add(new NetworkService().implNetworkService());
		setOfServices.add(new LocationService().implLocationService());
		return setOfServices;
	}

	/*
	 * public Map<String, Callable<String>> addServices() { listOfServices = new
	 * HashMap<>(); listOfServices.put("WeatherService", new
	 * WeatherService().implWeatherSerivice());
	 * listOfServices.put("LocationService", new
	 * LocationService().implLocationService());
	 * listOfServices.put("NetworkService", new
	 * NetworkService().implNetworkService()); return listOfServices; }
	 */
	public void implService() {
		try {
			getValuesFromServices = executor.invokeAll(appendServices());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void valuesFromServices(){
		for(Future<String> future: getValuesFromServices){
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executor.shutdown();
	}
}
