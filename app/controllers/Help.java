package controllers;

import controllers.casino.Secure;
import play.Play;
import play.data.validation.Email;
import play.data.validation.Required;
import play.exceptions.UnexpectedException;
import play.libs.Crypto;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Http;

public class Help extends Controller {

	@Before
	public static void setControllerName() throws Throwable {
		renderArgs.put("currentController",
				getControllerClass().getSimpleName());
		Http.Cookie remember = request.cookies.get("rememberme");
		if(remember != null && remember.value.indexOf("-") > 0) {
            String sign = remember.value.substring(0, remember.value.indexOf("-"));
            String username = remember.value.substring(remember.value.indexOf("-") + 1);
            if(Crypto.sign(username).equals(sign)) {
                session.put("username", username);
            }
        }
	}
	
	public static void index() {
		System.out.println("entree dans Help");
		render();
    }
	
	
	public static void sendMessage(@Required String name, @Required @Email String email, @Required String message) {
		System.out.println("Envoi d'un message");
		if (validation.hasErrors()) {
			flash.error("help.form.error");
			validation.keep();
			params.flash("name");
			params.flash("email");
			params.flash("message");
			index();
		} else {
			KooganMailer.sendMessage(name, email, message);
			flash.success("help.form.success");
			index();
		}
		
	}
}
