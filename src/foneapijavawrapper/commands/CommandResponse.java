package foneapijavawrapper.commands;

import com.google.gson.annotations.SerializedName;

public class CommandResponse {
	@SerializedName("status")
	private int status;
	@SerializedName("call_id")
	private String callId;
	@SerializedName("error_msg")
	private String errorMsg;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCallId() {
		return callId;
	}
	public void setCallId(String callId) {
		this.callId = callId;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
