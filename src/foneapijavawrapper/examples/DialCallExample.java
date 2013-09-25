package foneapijavawrapper.examples;

import foneapijavawrapper.commands.*;

public class DialCallExample {

	public static void main(String[] args) {
		FoneApiClient client = new FoneApiClient(
				"http://foneapi_server/api/1.0/switch",
				"****************************", "****************************");
		CommandResponse response = client.dial(eDialDestinationType.number,
				"5551234567",
				"htt://your_server/location_of_call_answered_event_handler", 0,
				"htt://your_server/location_of_error_event_handler", 30,
				"5557654321", "Lester Tester", 0, "verizon", null);
		if (response.getStatus() != 0) {
			System.out.println("Call failed with error: "
					+ response.getErrorMsg());
		} else {
			System.out.println("Call id: " + response.getCallId());
		}
	}
}
