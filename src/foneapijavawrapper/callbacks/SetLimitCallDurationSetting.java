package foneapijavawrapper.callbacks;

import com.google.gson.annotations.SerializedName;

class SetLimitCallDurationSetting extends Setting {

	@SerializedName("set_limit_call_duration")
	private SetLimitCallDurationSettingProperties properties;

	SetLimitCallDurationSetting(int seconds) {
		properties = new SetLimitCallDurationSettingProperties();
		properties.seconds = seconds;
	}

	private class SetLimitCallDurationSettingProperties {
		@SerializedName("seconds")
		int seconds;
	}
}
