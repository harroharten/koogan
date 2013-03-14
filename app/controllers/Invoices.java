package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.methods.GetMethod;

import models.Contact;
import models.Invoice;
import models.InvoiceDetail;
import models.KooganUser;
import play.Logger;
import play.data.binding.As;
import play.i18n.Messages;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;
import controllers.casino.Secure;

@With(Secure.class)
public class Invoices extends Controller {

	@Before
	public static void setControllerName() {
		renderArgs.put("currentController",
				getControllerClass().getSimpleName()); 
	}
	
	public static void index() {
		
		Logger.info("--> Entering " + getControllerClass().getSimpleName() + ".index()");
		
		List<Invoice> invoices = Invoice.findByCurrentUser();
		Logger.info("--> " + invoices.size() + " factures trouvees.");
		render(invoices);
	}
	
	public static void add() {
		Logger.info("--> Entering " + getControllerClass().getSimpleName() + ".add()");
		render();
	}
	
	public static void insert(Invoice invoice, List<InvoiceDetail> lines) {
		Logger.info("--> Entering " + getControllerClass().getSimpleName() + ".insert(" + invoice + ", " + lines + ")");
		
		Long totalAmount = 0L;
		
		List<InvoiceDetail> toRemove = new ArrayList<InvoiceDetail>();
		for (InvoiceDetail line : lines) {
			if (line != null) {
				if (line.description == null || "".equals(line.description)) {
					toRemove.add(line);
				} else {
					totalAmount += line.quantity * line.unitPrice;
					line.invoice = invoice;
				}
			}
		}
		lines.removeAll(toRemove);
		
		invoice.contact = Contact.findById(invoice.contact.id);
		
		invoice.invoiceDetails = new ArrayList<InvoiceDetail>();
		invoice.invoiceDetails.addAll(lines);
		invoice.totalAmount = totalAmount;
		invoice.user = KooganUser.getCurrentUser();
		invoice.save();
		
		show(invoice.id);
	}
	
	public static void show(Long id) {
		Logger.info("--> Entering " + getControllerClass().getSimpleName() + ".show(" + id + ")");
		Invoice invoice = Invoice.findById(id);
		if (invoice == null) {
			flash.error(Messages.get("invoice.show.notfound", id));
			index();
		}
		render(invoice);
	}
	
	public static void modify(Long id) {
		Logger.info("--> Entering " + getControllerClass().getSimpleName() + ".modify(" + id + ")");
		Invoice invoice = Invoice.findById(id);
		render(invoice);
	}
}
