package controllers;

import play.Play;
import play.i18n.Messages;
import play.mvc.Mailer;

public class KooganMailer extends Mailer {
	
	public static void sendMessage(String name, String email, String message) {
		Mailer.setSubject(Messages.get("help.message.subject", name));
		Mailer.addRecipient(Play.configuration.getProperty("email.admin"));
		Mailer.setFrom(email);
		Mailer.send("Help/message", name, message);
	}
}
