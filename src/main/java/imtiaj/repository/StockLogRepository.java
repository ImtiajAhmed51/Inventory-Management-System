package imtiaj.repository;

import imtiaj.model.StockLogEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockLogRepository{
    private SessionFactory sessionFactory;
    public StockLogRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void create(StockLogEntity sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(StockLogEntity sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        StockLogEntity sf = findById(id);
        session.delete(sf);
    }

    public List<StockLogEntity> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<StockLogEntity> userQuery = session.createQuery("from StockLogEntity", StockLogEntity.class);
        return userQuery.getResultList();
    }

    public StockLogEntity findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(StockLogEntity.class, id);
    }
}
