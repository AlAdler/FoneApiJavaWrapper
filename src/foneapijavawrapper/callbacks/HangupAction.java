package foneapijavawrapper.callbacks;

import com.google.gson.annotations.SerializedName;

class HangupAction extends Action {
	@SerializedName("hangup")
	private Object properties;

	HangupAction() {
		properties = new Object();
	}
}
