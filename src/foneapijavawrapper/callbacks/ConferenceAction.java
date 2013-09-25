package foneapijavawrapper.callbacks;

import com.google.gson.annotations.SerializedName;

class ConferenceAction extends Action {

	@SerializedName("conference")
	private ConferenceProperties properties;
	
	ConferenceAction(String room) {
		properties = new ConferenceProperties();
		properties.room = room;
	}
	
	private class ConferenceProperties{
		@SerializedName("room")
		String room;
	}
}
