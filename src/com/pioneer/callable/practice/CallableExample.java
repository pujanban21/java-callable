package com.pioneer.callable.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.Set;
import java.util.Date;
import java.util.HashSet;

public class CallableExample implements Callable<String> {


	@Override
	public String call() throws Exception {

		Thread.sleep(4000);
		return Thread.currentThread().getName();
	}

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		Set<Future<String>> set = new HashSet<>();
		
		for (int i =0; i <100; i++) {
			Callable<String> callable = new CallableExample();
			Future<String> future = pool.submit(callable);
			set.add(future);
		}

		String values;
		for (Future<String> future : set) {
			try {
				values = future.get();
				System.out.println(new Date() + "::" + values);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		pool.shutdown();
	}
}
