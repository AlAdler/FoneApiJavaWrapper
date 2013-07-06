package foneapijavawrapper.commands;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class FoneApiClient {

	private static final String DIAL_RESOURCE = "dial//";
	private static final String HANGUP_RESOURCE = "hangup//";
	private WebResource service;

	public FoneApiClient(String urlBase, String fapiKey, String fapiSecret) {
		ClientConfig clientConfig = new DefaultClientConfig();
		Client client = Client.create(clientConfig);
		client.addFilter(new HTTPBasicAuthFilter(fapiKey, fapiSecret));
		service = client.resource(urlBase);
	}

	public CommandResponse dial(eDialDestinationType destinationType,
			String destination, String url, Integer appId, String fallbackUrl,
			Integer dialTimeout, String callerIdNum, String callerIdName,
			Integer delay, String trunk) {
		CommandResponse retVal = null;
		try {
			MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
			queryParams.add(DialParams.DEST_TYPE, destinationType.toString());
			queryParams.add(DialParams.DEST, destination);
			queryParams.add(DialParams.URL, url);
			queryParams.add(DialParams.APP_ID, appId.toString());
			queryParams.add(DialParams.TRUNK, trunk);
            if (fallbackUrl != null && fallbackUrl != "")
            {
            	queryParams.add(DialParams.FALLBACK_URL, fallbackUrl);
            }
            if (dialTimeout != null)
            {
                queryParams.add(DialParams.DIAL_TIMEOUT, dialTimeout.toString());
            }
            if (callerIdNum != null && callerIdNum != "")
            {
                queryParams.add(DialParams.CALLER_ID_NUM, callerIdNum);
            }
            if (callerIdName != null && callerIdName != "")
            {
                queryParams.add(DialParams.CALLER_ID_NAME, callerIdName);
            }
            if (delay != null)
            {
                queryParams.add(DialParams.DELAY, delay.toString());
            }
			ClientResponse response = service.queryParams(queryParams)
					.path(DIAL_RESOURCE).accept(MediaType.APPLICATION_JSON)
					.get(ClientResponse.class);
			if (response.getStatus() == 200) {
				retVal = instantiateCommandResponeFromJson(response);
			} else {
				retVal = new CommandResponse();
				retVal.setStatus(-10);
				retVal.setErrorMsg("Failed : HTTP error code : "
						+ response.getStatus());
			}
		} catch (Exception e) {
			retVal = new CommandResponse();
			retVal.setStatus(-20);
			retVal.setErrorMsg("Failed with exception: " + e.getMessage());
		}
		return retVal;
	}

	private CommandResponse instantiateCommandResponeFromJson(ClientResponse response) {
		String json = response.getEntity(String.class);
		Gson gson = new Gson();
		return gson.fromJson(json, CommandResponse.class);
	}

	public CommandResponse hangup(String callId) {
		CommandResponse retVal = null;
		try {
			MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
			queryParams.add(HangupParams.CALL_ID, callId);
			ClientResponse response = service.queryParams(queryParams)
					.path(HANGUP_RESOURCE).accept(MediaType.APPLICATION_JSON)
					.get(ClientResponse.class);
			if (response.getStatus() == 200) {
				retVal = instantiateCommandResponeFromJson(response);
			} else {
				retVal = new CommandResponse();
				retVal.setCallId(callId);
				retVal.setStatus(-10);
				retVal.setErrorMsg("Failed : HTTP error code : "
						+ response.getStatus());
			}
		} catch (Exception e) {
			retVal = new CommandResponse();
			retVal.setCallId(callId);
			retVal.setStatus(-20);
			retVal.setErrorMsg("Failed with exception: " + e.getMessage());
		}
		return retVal;
	}
}
