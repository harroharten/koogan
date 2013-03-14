package models.enums;

import java.util.ArrayList;
import java.util.List;

import play.i18n.Messages;


// http://en.wikipedia.org/wiki/Sales_process
public enum SalesProcess {
	
	PROSPECT, CUSTOMER, ARCHIVED;

	 
	public static List<String> getI18nValues() {
		SalesProcess[] values = values();
		List<String> result = new ArrayList<String>();
		for (SalesProcess status : values) {
			result.add(Messages.get(status));
		}
		return result;
	}
}
