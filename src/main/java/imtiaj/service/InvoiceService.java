package imtiaj.service;
import imtiaj.model.Invoice;
import imtiaj.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public void create(Invoice invoice) {
        invoiceRepository.create(invoice);
    }


    public Invoice findById(int id) {
        return invoiceRepository.findById(id);
    }

    public List<Invoice> findAll() {
        return invoiceRepository.getAll();
    }

    public void updateInvoice(Invoice invoice) {
        invoiceRepository.edit(invoice);
    }

    public void deleteInvoice(Invoice invoice) {
        invoiceRepository.delete(invoice.getInvoiceId());
    }



}
