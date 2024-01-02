package imtiaj.restController;

import imtiaj.model.Invoice;
import imtiaj.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoices")
    public Iterable<Invoice> getAllInvoice() {
        return invoiceService.findAll();
    }

    @GetMapping("/invoices/{id}")
    public Invoice searchInvoice(@PathVariable int id) {
        return invoiceService.findById(id);
    }

    @PostMapping("/invoices")
    public void addInvoice(@RequestBody Invoice invoice) {
        invoiceService.create(invoice);
    }

    @PutMapping("/invoices/{id}")
    public void updateInvoice(@RequestBody Invoice invoice) {
        invoiceService.updateInvoice(invoice);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/invoices/{id}")
    public void deleteInvoice(@RequestBody Invoice invoice) {
        invoiceService.deleteInvoice(invoice);
    }

}
