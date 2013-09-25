package foneapijavawrapper.callbacks;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import foneapijavawrapper.utils.CustomParameter;

public class CallBackResponse {

	@SerializedName("actions")
	private ArrayList<Action> actions;
	@SerializedName("settings")
	private ArrayList<Setting> settings;

	public CallBackResponse() {
		actions = new ArrayList<Action>();
	}

	public CallBackResponse(int limitCallDurationSeconds) {
		this();
		settings = new ArrayList<Setting>();
		setLimitCallDuration(limitCallDurationSeconds);
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public void setLimitCallDuration(int limitCallDurationSeconds) {
		for (Setting item : settings) {
			if (item instanceof SetLimitCallDurationSetting) {
				settings.remove(item);
				break;
			}
		}
		SetLimitCallDurationSetting limitCallSetting = new SetLimitCallDurationSetting(
				limitCallDurationSeconds);
		settings.add(limitCallSetting);
	}

	public void answer() {
		AnswerAction answerAction = new AnswerAction();
		actions.add(answerAction);
	}

	public void hangup() {
		HangupAction hangupAction = new HangupAction();
		actions.add(hangupAction);
	}

	public void dial(String numbers, String callerId, String url,
			Boolean record, CustomParameter... customParameters) {
		DialAction dialAction = new DialAction(numbers, callerId, url, record,
				customParameters);
		actions.add(dialAction);
	}

	public void bridgeTo(String otherCallId, String url,
			CustomParameter... customParameters) {
		BridgeToAction bridgeToAction = new BridgeToAction(otherCallId, url,
				customParameters);
		actions.add(bridgeToAction);
	}

	public void say(String text, Voice voice, Language language) {
		SayAction sayAction = new SayAction(text, voice, language);
		actions.add(sayAction);
	}

	public void getDtmf(int maxLength, String terminationKey, int timeout,
			String url) {
		GetDtmfAction getDtmfAction = new GetDtmfAction(maxLength,
				terminationKey, timeout, url);
		actions.add(getDtmfAction);
	}

	public void conference(String room) {
		ConferenceAction conferenceAction = new ConferenceAction(room);
		actions.add(conferenceAction);
	}

	public void playFile(String fileUrl, String url,
			CustomParameter... customParameters) {
		PlayFileAction playFileAction = new PlayFileAction(fileUrl, url,
				customParameters);
		actions.add(playFileAction);
	}

	public void playAndGetDtmf(String fileUrl, String url, int maxLength,
			int timeout, String terminationKey,
			CustomParameter... customParameters) {
		PlayAndGetDtmfAction playAndGetDtmfAction = new PlayAndGetDtmfAction(
				fileUrl, url, maxLength, timeout, terminationKey,
				customParameters);
		actions.add(playAndGetDtmfAction);
	}
}
