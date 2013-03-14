package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import models.enums.SalesProcess;
import models.enums.Status;
import play.db.jpa.Model;

@Entity
public class Account extends Model {
	
	@Column(unique = true)
	public String name;
	@Enumerated(EnumType.STRING)
	public Status status;
	@Enumerated(EnumType.STRING)
	public SalesProcess salesProcess;
	public Date created;
	
	@ManyToOne
	public KooganUser user;
	
	public static List<Account> getAccountsByUser(KooganUser user) {
		List<Account> listAccounts = Account.find("byUser", user).fetch();
		return listAccounts;
	}
	
	public static List<Account> getAccountsByCurrentUser() {
		List<Account> listAccounts = Account.find("byUser", KooganUser.getCurrentUser()).fetch();
		return listAccounts;
	}

}
