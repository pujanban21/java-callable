package com.pioneer.callable.practice;

import java.util.concurrent.Callable;

public class NetworkService {

	public Callable<String> implNetworkService() {
		Callable<String> callableNetworkService = new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "Network Service Implemented";
			}
		};
		return callableNetworkService;
	}

}
