package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Account;
import models.Contact;
import models.KooganUser;
import play.Logger;
import play.i18n.Messages;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
import controllers.casino.Check;
import controllers.casino.Secure;
import controllers.casino.Security;

@With(Secure.class)
public class Contacts extends Controller {

	@Before
	public static void setControllerName() {
		renderArgs.put("currentController",
				getControllerClass().getSimpleName()); 
	}
    
	@Check("isConnected")
	public static void index() {
		Logger.info("--> Entering " + getControllerClass().getSimpleName() + ".index()");
		List<Contact> contacts = Contact.findByUser(KooganUser.getCurrentUser());
		render(contacts);
	}
	
	@Check("isConnected")
    public static void insert(Contact contact, Account account) {
    	System.out.println(" ***   Adding a contact   *** ");
    	System.out.println("    -- Last_name : " + contact.lastName);
    	System.out.println("    -- First_name : " + contact.firstName);
    	
    	account = Account.find("name = ?", account.name).first();
    	
    	contact.account = account;
    	contact.user = KooganUser.getCurrentUser();
    	contact.save();
    	
    	flash.success("Contact %s added", contact.lastName);
    	
    	show(contact.id);
    }

	public static void show(Long id) {
		Contact contact = Contact.findById(id);
		if (contact == null) {
			flash.error(Messages.get("contact.show.notfound", id));
			index();
		}
		render(contact);
	}
	
	public static void delete(Long id) {
		Contact contact = Contact.findById(id);
		contact.delete();
		
		listContactsTable();
		
	}

	public static void add() {
		render();
	}


	public static void listContactsTable() {
		List<Contact> contacts = Contact.findByUser(KooganUser.getCurrentUser());
        renderTemplate("Contacts/listTable.html", contacts);
	}

	public static void modify(Long id) {
		Contact contact = Contact.findById(id);
		render(contact);
	}
	
	public static void update(Contact contact, Account account) {

    	account = Account.find("name = ?", account.name).first();
		contact.account = account;
		
    	contact.user = KooganUser.getCurrentUser();
    	
		contact.save();
		show(contact.id);
	}
}
