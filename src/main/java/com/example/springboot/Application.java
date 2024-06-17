package com.example.springboot;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws JSONException {
		JSONArray json = new JSONArray();
		System.out.println(json.length()>0);
		SpringApplication.run(Application.class, args);
	}
}
