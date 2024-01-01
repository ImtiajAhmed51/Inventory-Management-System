package imtiaj.repository;
import imtiaj.model.PricingLogEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PricingLogRepository {

    private SessionFactory sessionFactory;
    public PricingLogRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void create(PricingLogEntity sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(PricingLogEntity sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        PricingLogEntity sf = findById(id);
        session.delete(sf);
    }

    public List<PricingLogEntity> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<PricingLogEntity> userQuery = session.createQuery("from PricingLogEntity", PricingLogEntity.class);
        return userQuery.getResultList();
    }

    public PricingLogEntity findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(PricingLogEntity.class, id);
    }
}
