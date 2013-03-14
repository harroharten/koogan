package controllers;

import java.util.List;

import models.Contact;
import models.KooganUser;
import play.Logger;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
import controllers.casino.Check;
import controllers.casino.Secure;

@With(Secure.class)
public class Activities extends Controller {

	@Before
	public static void setControllerName() {
		renderArgs.put("currentController",
				getControllerClass().getSimpleName()); 
	}
    
	public static void index() {
		Logger.info("--> Entering " + getControllerClass().getSimpleName() + ".index()");
		render();
	}

	public static void add() {
		Logger.info("--> Entering " + getControllerClass().getSimpleName() + ".add()");
		render();
	}
}
