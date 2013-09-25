package foneapijavawrapper.callbacks;

import com.google.gson.annotations.SerializedName;

import foneapijavawrapper.utils.CustomParameter;
import foneapijavawrapper.utils.Utils;

class DialAction extends Action {
	@SerializedName("dial")
	private DialProperties properties;

	DialAction(String numbers, String callerId, String url, Boolean record, CustomParameter... customParameters) {
		properties = new DialProperties();
		properties.numbers = numbers;
		properties.callerId = callerId;
		url = Utils.addCustomParamsToUrl(url, customParameters);
		properties.url = url;
		properties.record = record;
	}

	private class DialProperties {
		@SerializedName("numbers")
		String numbers;
		@SerializedName("url")
		String url;
		@SerializedName("caller_id")
		String callerId;
		@SerializedName("record")
		Boolean record;
	}
}
