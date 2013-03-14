package controllers;

import java.util.List;

import models.Contact;
import models.KooganUser;

import org.apache.commons.lang.StringUtils;

import controllers.casino.Check;
import controllers.casino.Secure;

import casino.CasinoApplicationConfConstants;

import play.Play;
import play.data.validation.Email;
import play.data.validation.Required;
import play.i18n.Messages;
import play.libs.Codec;
import play.libs.Crypto;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Mailer;

public class Application extends Controller {

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
		System.out.println("entree dans index");
		render();
    }
	
	public static void robots()  {
		 render("robots.txt"); 
	}
	
}