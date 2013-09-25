/**
 * 
 */
package foneapijavawrapper.callbacks;

import com.google.gson.annotations.SerializedName;

import foneapijavawrapper.utils.CustomParameter;
import foneapijavawrapper.utils.Utils;

/**
 * @author Alain Adler
 * 
 */
class BridgeToAction extends Action {
	@SerializedName("bridge_to")
	private BridgeToActionProperties properties;

	BridgeToAction(String otherCallId, String url, CustomParameter... customParameters) {
		properties = new BridgeToActionProperties();
		properties.otherCallId = otherCallId;
		url = Utils.addCustomParamsToUrl(url, customParameters);
		properties.url = url;
	}
	
	private class BridgeToActionProperties {
		@SerializedName("other_call_id")
		String otherCallId;
		@SerializedName("url")
		String url;
	}
}
