package controllers;

import java.util.List;

import controllers.casino.Secure;

import models.Account;
import models.Contact;
import models.KooganUser;
import play.i18n.Messages;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Accounts extends Controller {

	@Before
	public static void setControllerName() {
		renderArgs.put("currentController",
				getControllerClass().getSimpleName()); 
	}
    
    public static void insert(Account account) {
    	System.out.println(" ***   Adding an account   *** ");
    	System.out.println("    -- Name : " + account.name);
    	
    	account.user = KooganUser.getCurrentUser();
    	account.save();
    	
    	flash.success("Account %s added", account.name);
    	
    	show(account.id);
    }
    
	
	public static void index() {
		List<Account> accounts = Account.getAccountsByUser(KooganUser.getCurrentUser());
        render(accounts);
	}

	public static void show(Long id) {
		Account account = Account.findById(id);
		if (account == null) {
			flash.error(Messages.get("account.show.notfound", id));
			index();
		}
		render(account);
	}
	
	public static void delete(Long id) {
		Account account = Account.findById(id);
		account.delete();

		List<Account> accounts = Account.getAccountsByUser(KooganUser.getCurrentUser());
        renderTemplate("Accounts/listTable.html", accounts);
		
	}

	public static void add() {
		render();
	}
	

	public static void modify(Long id) {
		Account account = Account.findById(id);
		render(account);
	}
	
	public static void update(Account account) {
    	
    	account.user = KooganUser.getCurrentUser();
    	account.save();
    	
    	flash.success("Account %s added", account.name);
    	
    	show(account.id);
	}
}
