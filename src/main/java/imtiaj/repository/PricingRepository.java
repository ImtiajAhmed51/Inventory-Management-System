package imtiaj.repository;

import imtiaj.model.Pricing;
import imtiaj.model.PricingLogEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PricingRepository {


    private SessionFactory sessionFactory;
    public PricingRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void create(Pricing sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(Pricing sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Pricing sf = findById(id);
        session.delete(sf);
    }

    public List<Pricing> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Pricing> userQuery = session.createQuery("from Pricing", Pricing.class);
        return userQuery.getResultList();
    }

    public Pricing findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Pricing.class, id);
    }
}
