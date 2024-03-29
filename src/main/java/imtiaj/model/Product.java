package imtiaj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    private String createdUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDateTime;

    private String lastModifiedUser;

    private double productbuyingPrice;

    private byte productIsService;

    private String productName;

    private double productsellingPrice;

    private BigDecimal version;

    //bi-directional many-to-one association to Category
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    //bi-directional many-to-one association to ProductInvoice
    @OneToMany(mappedBy = "product")
    private List<ProductInvoice> productInvoices;

    //bi-directional many-to-one association to ProductPricing
    @OneToMany(mappedBy = "product")
    private List<ProductPricing> productPricings;

    //bi-directional many-to-one association to Stock
    @OneToMany(mappedBy = "product")
    private List<Stock> stocks;

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public double getProductbuyingPrice() {
        return this.productbuyingPrice;
    }

    public void setProductbuyingPrice(double productbuyingPrice) {
        this.productbuyingPrice = productbuyingPrice;
    }

    public byte getProductIsService() {
        return this.productIsService;
    }

    public void setProductIsService(byte productIsService) {
        this.productIsService = productIsService;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductsellingPrice() {
        return this.productsellingPrice;
    }

    public void setProductsellingPrice(double productsellingPrice) {
        this.productsellingPrice = productsellingPrice;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonIgnore
    public List<ProductInvoice> getProductInvoices() {
        return this.productInvoices;
    }

    public void setProductInvoices(List<ProductInvoice> productInvoices) {
        this.productInvoices = productInvoices;
    }

    public ProductInvoice addProductInvoice(ProductInvoice
                                                    productInvoice) {
        getProductInvoices().add(productInvoice);
        productInvoice.setProduct(this);

        return productInvoice;
    }


    public ProductInvoice removeProductInvoice(ProductInvoice productInvoice) {
        getProductInvoices().remove(productInvoice);
        productInvoice.setProduct(null);

        return productInvoice;
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
        productPricing.setProduct(this);

        return productPricing;
    }

    public ProductPricing removeProductPricing(ProductPricing productPricing) {
        getProductPricings().remove(productPricing);
        productPricing.setProduct(null);

        return productPricing;
    }

    @JsonIgnore
    public List<Stock> getStocks() {
        return this.stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public Stock addStock(Stock stock) {
        getStocks().add(stock);
        stock.setProduct(this);

        return stock;
    }

    public Stock removeStock(Stock stock) {
        getStocks().remove(stock);
        stock.setProduct(null);

        return stock;
    }

}