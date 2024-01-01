package imtiaj.repository;


import imtiaj.model.ProductLogEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductLogRepository{
    private SessionFactory sessionFactory;
    public ProductLogRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void create(ProductLogEntity sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(ProductLogEntity sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        ProductLogEntity sf = findById(id);
        session.delete(sf);
    }

    public List<ProductLogEntity> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<ProductLogEntity> userQuery = session.createQuery("from ProductLogEntity", ProductLogEntity.class);
        return userQuery.getResultList();
    }

    public ProductLogEntity findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ProductLogEntity.class, id);
    }
}
