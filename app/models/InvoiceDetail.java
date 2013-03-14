package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class InvoiceDetail extends Model {

	
	public String description;
	public Long unitPrice;
	public Long quantity;
	public Long tax;
	public Long price;
	
	@ManyToOne
	@Required
	public Invoice invoice;
}
