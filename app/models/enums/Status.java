package models.enums;

import java.util.ArrayList;
import java.util.List;

import play.i18n.Messages;

public enum Status {
	

	SARL, SAS, EURL, SA, SASU;

	private static String i18nPrefix = "enum.status."; 
	 
	public static List<String> getI18nValues() {
		Status[] values = values();
		List<String> result = new ArrayList<String>();
		for (Status status : values) {
			result.add(Messages.get(i18nPrefix + status));
		}
		return result;
	}
	
}
