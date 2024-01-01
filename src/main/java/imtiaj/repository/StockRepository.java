package imtiaj.repository;

import imtiaj.model.ProductPricing;
import imtiaj.model.Stock;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StockRepository {
    private SessionFactory sessionFactory;
    public StockRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void create(Stock sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(Stock sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Stock sf = findById(id);
        session.delete(sf);
    }

    public List<Stock> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Stock> userQuery = session.createQuery("from Stock", Stock.class);
        return userQuery.getResultList();
    }

    public Stock findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Stock.class, id);
    }
}
