package controllers;


import java.util.Date;

import models.KooganUser;
import casino.AfterUserCreationHook;

public class KooganAfterUserCreationHook implements AfterUserCreationHook {

	@Override
	public void execute(String email) {
		KooganUser user = new KooganUser();
		user.email = email;
		user.creationDate = new Date();
		
		user.save();
	}

}
