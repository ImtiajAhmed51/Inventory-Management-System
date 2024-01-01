package imtiaj.repository;
import imtiaj.model.Invoice;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceRepository  {
    private SessionFactory sessionFactory;
    public InvoiceRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void create(Invoice sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(Invoice sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Invoice sf = findById(id);
        session.delete(sf);
    }

    public List<Invoice> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Invoice> userQuery = session.createQuery("from Invoice", Invoice.class);
        return userQuery.getResultList();
    }

    public Invoice findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Invoice.class, id);
    }
}
