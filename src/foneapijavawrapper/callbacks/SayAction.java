package foneapijavawrapper.callbacks;

import com.google.gson.annotations.SerializedName;

class SayAction extends Action {

	@SerializedName("say")
	private SayProperties properties;
	
	SayAction(String text, Voice voice, Language language){
		properties = new SayProperties();
		properties.text = text;
		properties.voice = voice.name();
		properties.language = language.name();
	}
	
	private class SayProperties{
		@SerializedName("voice")
		String voice;
		@SerializedName("text")
		String text;
		@SerializedName("language")
		String language;
	}
}
