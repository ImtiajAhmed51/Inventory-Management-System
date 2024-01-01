package imtiaj.repository;

import imtiaj.model.ProductInvoice;
import imtiaj.model.ProductLogEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductInvoiceRepository {
    private SessionFactory sessionFactory;
    public ProductInvoiceRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void create(ProductInvoice sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(ProductInvoice sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        ProductInvoice sf = findById(id);
        session.delete(sf);
    }

    public List<ProductInvoice> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<ProductInvoice> userQuery = session.createQuery("from ProductInvoice", ProductInvoice.class);
        return userQuery.getResultList();
    }

    public ProductInvoice findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ProductInvoice.class, id);
    }
}
