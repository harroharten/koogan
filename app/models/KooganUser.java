package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import controllers.casino.Security;

import play.db.jpa.Model;


@Entity
public class KooganUser extends Model {

	public String firstName;
	public String lastName;
	public String email;
	public Date creationDate;
	@ManyToOne
	public Organisation organisation;
	
	public static KooganUser connect(String email, String md5Password) {
	    return find("byEmailAndPassword", email, md5Password).first();
	}

	public static KooganUser getUserByEmail(String email) {
        KooganUser user = KooganUser.find("byEmail", email).first();
		return user;
	}
	
	public static KooganUser getCurrentUser() {
		String connectedUser = Security.connected();
		if (connectedUser != null) {
			return KooganUser.find("byEmail", connectedUser).first();
		}
		return null;
	}
}
