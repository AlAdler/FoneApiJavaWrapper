package foneapijavawrapper.utils;

import java.util.AbstractMap;

public class CustomParameter extends AbstractMap.SimpleEntry<String, String> {

	private static final long serialVersionUID = 1L;

	public CustomParameter(String key, String value) {
		super(key, value);
	}

}
