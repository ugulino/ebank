package io.app.ebank.utils;

public class JsonMessage {
	private static String templateString = "{\"message\":\"%s\"}";
	public static String get(String value) {
		return String.format(templateString, value); 
	};
}
