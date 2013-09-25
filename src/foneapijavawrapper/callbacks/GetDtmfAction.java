package foneapijavawrapper.callbacks;

import com.google.gson.annotations.SerializedName;

class GetDtmfAction extends Action {

	@SerializedName("get_dtmf")
	private GetDtmfProperties properties;

	GetDtmfAction(int maxLength, String terminationKey, int timeout,
			String url) {
		properties = new GetDtmfProperties();
		properties.maxLength = maxLength;
		properties.terminationKey = terminationKey;
		properties.timeout = timeout;
		properties.url = url;
	}

	private class GetDtmfProperties {
		@SerializedName("max_length")
		int maxLength;
		@SerializedName("termination_key")
		String terminationKey;
		@SerializedName("timeout")
		int timeout;
		@SerializedName("url")
		String url;
	}
}
