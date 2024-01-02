package imtiaj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;

    private double lineTotal;

    private int productId;

    private String productName;

    private double quantity;

    private double total;

    private BigDecimal version;

    //bi-directional many-to-one association to ProductInvoice
    @OneToMany(mappedBy = "invoice")
    private List<ProductInvoice> productInvoices;

    public Invoice() {
    }

    public int getInvoiceId() {
        return this.invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getLineTotal() {
        return this.lineTotal;
    }

    public void setLineTotal(double lineTotal) {
        this.lineTotal = lineTotal;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    @JsonIgnore
    public List<ProductInvoice> getProductInvoices() {
        return this.productInvoices;
    }

    public void setProductInvoices(List<ProductInvoice> productInvoices) {
        this.productInvoices = productInvoices;
    }

    public ProductInvoice addProductInvoice(ProductInvoice productInvoice) {
        getProductInvoices().add(productInvoice);
        productInvoice.setInvoice(this);

        return productInvoice;
    }

    public ProductInvoice removeProductInvoice(ProductInvoice productInvoice) {
        getProductInvoices().remove(productInvoice);
        productInvoice.setInvoice(null);

        return productInvoice;
    }

}