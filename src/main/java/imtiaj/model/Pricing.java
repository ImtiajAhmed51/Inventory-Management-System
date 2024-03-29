package imtiaj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Pricing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pricingId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    private String createdUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;

    private String lastModifiedUser;

    private BigDecimal pricingDiscountPrecentage;

    @Temporal(TemporalType.DATE)
    private Date pricingEffectiveDate;

    @Temporal(TemporalType.DATE)
    private Date pricingExpireDate;

    private String pricingName;

    private BigDecimal version;

    //bi-directional many-to-one association to ProductPricing
    @OneToMany(mappedBy = "pricing")
    private List<ProductPricing> productPricings;

    public Pricing() {
    }

    public int getPricingId() {
        return this.pricingId;
    }

    public void setPricingId(int pricingId) {
        this.pricingId = pricingId;
    }

    public Date getCreatedDateTime() {
        return this.createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getCreatedUser() {
        return this.createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getLastModifiedDateTime() {
        return this.lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(Date lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public BigDecimal getPricingDiscountPrecentage() {
        return this.pricingDiscountPrecentage;
    }

    public void setPricingDiscountPrecentage(BigDecimal pricingDiscountPrecentage) {
        this.pricingDiscountPrecentage = pricingDiscountPrecentage;
    }

    public Date getPricingEffectiveDate() {
        return this.pricingEffectiveDate;
    }

    public void setPricingEffectiveDate(Date pricingEffectiveDate) {
        this.pricingEffectiveDate = pricingEffectiveDate;
    }

    public Date getPricingExpireDate() {
        return this.pricingExpireDate;
    }

    public void setPricingExpireDate(Date pricingExpireDate) {
        this.pricingExpireDate = pricingExpireDate;
    }

    public String getPricingName() {
        return this.pricingName;
    }

    public void setPricingName(String pricingName) {
        this.pricingName = pricingName;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    @JsonIgnore
    public List<ProductPricing> getProductPricings() {
        return this.productPricings;
    }

    public void setProductPricings(List<ProductPricing> productPricings) {
        this.productPricings = productPricings;
    }

    public ProductPricing addProductPricing(ProductPricing productPricing) {
        getProductPricings().add(productPricing);
        productPricing.setPricing(this);

        return productPricing;
    }

    public ProductPricing removeProductPricing(ProductPricing productPricing) {
        getProductPricings().remove(productPricing);
        productPricing.setPricing(null);

        return productPricing;
    }

}