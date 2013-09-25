package foneapijavawrapper.callbacks;

import com.google.gson.annotations.SerializedName;

import foneapijavawrapper.utils.CustomParameter;
import foneapijavawrapper.utils.Utils;

class PlayAndGetDtmfAction extends Action {

	@SerializedName("play_and_get_dtmf")
	private PlayAndGetDtmfProperties properties;

	PlayAndGetDtmfAction(String fileUrl, String url, int maxLength,
			int timeout, String terminationKey,
			CustomParameter... customParameters) {
		properties = new PlayAndGetDtmfProperties();
		properties.fileUrl = fileUrl;
		url = Utils.addCustomParamsToUrl(url, customParameters);
		properties.url = url;
		properties.maxLength = maxLength;
		properties.terminationKey = terminationKey;
		properties.timeout = timeout;
	}

	private class PlayAndGetDtmfProperties {
		@SerializedName("file_url")
		String fileUrl;
		@SerializedName("url")
		String url;
		@SerializedName("max_length")
		int maxLength;
		@SerializedName("termination_key")
		String terminationKey;
		@SerializedName("timeout")
		int timeout;
	}
}
