package imtiaj.repository;

import imtiaj.model.Stock;
import imtiaj.model.SupplierLogEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierLogRepository {
    private SessionFactory sessionFactory;

    public SupplierLogRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(SupplierLogEntity sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(SupplierLogEntity sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        SupplierLogEntity sf = findById(id);
        session.delete(sf);
    }

    public List<SupplierLogEntity> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<SupplierLogEntity> userQuery = session.createQuery("from SupplierLogEntity", SupplierLogEntity.class);
        return userQuery.getResultList();
    }

    public SupplierLogEntity findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(SupplierLogEntity.class, id);
    }
}
