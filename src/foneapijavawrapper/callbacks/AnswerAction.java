package foneapijavawrapper.callbacks;

import com.google.gson.annotations.SerializedName;

class AnswerAction extends Action {
	@SerializedName("answer")
	private Object properties;

	AnswerAction() {
		properties = new Object();
	}
}
