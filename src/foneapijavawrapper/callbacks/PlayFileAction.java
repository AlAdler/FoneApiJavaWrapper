package foneapijavawrapper.callbacks;

import com.google.gson.annotations.SerializedName;

import foneapijavawrapper.utils.CustomParameter;
import foneapijavawrapper.utils.Utils;

class PlayFileAction extends Action {

	@SerializedName("play_file")
	private PlayFileProperties properties;

	PlayFileAction(String fileUrl, String url,
			CustomParameter... customParameters) {
		properties = new PlayFileProperties();
		properties.fileUrl = fileUrl;
		url = Utils.addCustomParamsToUrl(url, customParameters);
		properties.url = url;
	}

	private class PlayFileProperties {
		@SerializedName("file_url")
		String fileUrl;
		@SerializedName("url")
		String url;
	}
}
