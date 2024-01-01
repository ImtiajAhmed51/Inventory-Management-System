package imtiaj.repository;

import imtiaj.model.Supplier;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierRepository {
    private SessionFactory sessionFactory;
    public SupplierRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void create(Supplier sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(Supplier sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Supplier sf = findById(id);
        session.delete(sf);
    }

    public List<Supplier> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Supplier> userQuery = session.createQuery("from Supplier", Supplier.class);
        return userQuery.getResultList();
    }

    public Supplier findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Supplier.class, id);
    }
}
