package controllers;

import java.util.List;

import controllers.casino.Secure;

import models.Contact;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Dashboard extends Controller {
	
	@Before
	public static void setControllerName() {
		renderArgs.put("currentController",
				getControllerClass().getSimpleName()); 
	}
	

	public static void index() {
		System.out.println("entrée dans Dashboard");
    	List<Contact> contacts = Contact.findAll();
        render(contacts);
    }
}
