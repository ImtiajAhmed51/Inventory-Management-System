package imtiaj.model;

import javax.persistence.*;


/**
 * The persistent class for the product_invoice database table.
 * 
 */
@Entity
@Table(name="product_invoice")
public class ProductInvoice {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int refId;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	private Invoice invoice;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public ProductInvoice() {
	}

	public int getRefId() {
		return this.refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}