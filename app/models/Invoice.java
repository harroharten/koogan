package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.binding.As;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Invoice extends Model {
	
	@Required
	public String		invoiceNumber;
	public String		label;
	public String 		status;
	public Long 		totalAmount;
	@As(lang={"fr,de","*"}, value={"dd-MM-yyyy","MM-dd-yyyy"}) 
	public Date 		dateCreated;
	public Date 		dateModified;
	
	@OneToMany(mappedBy="invoice", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public List<InvoiceDetail> invoiceDetails;
	
	@ManyToOne
	public Contact		contact;
	@ManyToOne
	public KooganUser	user;
	
	@Lob
	public String		comments;
	
	public Invoice() {
//		this.dateCreated = new Date();
		this.dateModified = new Date();
		this.invoiceDetails = new ArrayList<InvoiceDetail>();
	}

	public static List<Invoice> findByUser(KooganUser user) {
		List<Invoice> listInvoices = Invoice.find("byUser", user).fetch();
		return listInvoices;
	}
	
	public static List<Invoice> findByCurrentUser() {
		List<Invoice> listInvoices = Invoice.find("byUser", KooganUser.getCurrentUser()).fetch();
		return listInvoices;
	}

	@Override
	public String toString() {
		return invoiceNumber + " (" + dateCreated + ") " + contact;
	}
	
}
