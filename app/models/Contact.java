package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import models.enums.CivilTitle;
import models.enums.Country;
import play.db.jpa.Model;

@Entity
public class Contact extends Model {

	@Enumerated(EnumType.STRING)
	public CivilTitle civilTitle;
	public String firstName;
	public String lastName;
	public String function;
	public String phoneNumber;
	public String cellphoneNumber;
	public String faxNumber;
	public String address;
	public String postalCode;
	public String city;
	@Enumerated(EnumType.STRING)
	public Country country;
	public String email;

	@ManyToOne
	public Account account;
	
	@OneToMany(mappedBy="contact", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<Invoice> invoices;
	
	@ManyToOne
	public KooganUser user;
	
	@Lob
	public String comments;
	public Date created;
	
	public static List<Contact> findByUser(KooganUser user) {
		List<Contact> listContacts = Contact.find("byUser", user).fetch();
		return listContacts;
	}
	
	public static List<Contact> findByCurrentUser() {
		List<Contact> listContacts = Contact.find("byUser", KooganUser.getCurrentUser()).fetch();
		return listContacts;
	}

	@Override
	public String toString() {
		String accountToString = "";
		if (account != null) {
			accountToString = " (" + account.name + ")";
		}
		String string = firstName + " " + lastName + accountToString;
		return string;
	}
	
}
