package imtiaj.repository;

import imtiaj.model.ProductPricing;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductPricingRepository{
    private SessionFactory sessionFactory;
    public ProductPricingRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void create(ProductPricing sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(ProductPricing sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        ProductPricing sf = findById(id);
        session.delete(sf);
    }

    public List<ProductPricing> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<ProductPricing> userQuery = session.createQuery("from ProductPricing", ProductPricing.class);
        return userQuery.getResultList();
    }

    public ProductPricing findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ProductPricing.class, id);
    }
}
