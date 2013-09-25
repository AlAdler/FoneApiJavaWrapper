package foneapijavawrapper.utils;

public class Utils {
	private static final String QUESTION_MARK = "?";
	private static final String AND_SIGN = "&";
	private static final String EQUALS_SIGN = "=";

	public static String addCustomParamsToUrl(String url,
			CustomParameter... customParams) {
		String retVal = url;
		if (retVal != null && customParams.length > 0) {
			StringBuilder builder = new StringBuilder(retVal);
			for (int i = 0; i < customParams.length; i++) {
				if (i == 0) {
					builder.append(QUESTION_MARK);
				} else {
					builder.append(AND_SIGN);
				}
				builder.append(customParams[i].getKey()).append(EQUALS_SIGN)
						.append(customParams[i].getValue());
			}
			retVal = builder.toString();
		}
		return retVal;
	}
}
