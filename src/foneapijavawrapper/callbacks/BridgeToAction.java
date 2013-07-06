/**
 * 
 */
package foneapijavawrapper.callbacks;

import com.google.gson.annotations.SerializedName;

/**
 * @author Alain Adler
 * 
 */
class BridgeToAction extends Action {
	@SerializedName("bridge_to")
	private BridgeToActionProperties properties;

	BridgeToAction(String otherCallId, String url) {
		properties = new BridgeToActionProperties();
		properties.otherCallId = otherCallId;
		// url = Utils.AddCustomParamsToUrl(url, customParams);
		properties.url = url;
	}

	// [JsonObject]
	private class BridgeToActionProperties {
		@SerializedName("other_call_id")
		String otherCallId;
		@SerializedName("url")
		String url;
	}
}
