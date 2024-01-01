package imtiaj.model;

import javax.persistence.*;


/**
 * The persistent class for the product_pricing database table.
 * 
 */
@Entity
@Table(name="product_pricing")
public class ProductPricing {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int refId;

	//bi-directional many-to-one association to Pricing
	@ManyToOne
	private Pricing pricing;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public ProductPricing() {
	}

	public int getRefId() {
		return this.refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public Pricing getPricing() {
		return this.pricing;
	}

	public void setPricing(Pricing pricing) {
		this.pricing = pricing;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}