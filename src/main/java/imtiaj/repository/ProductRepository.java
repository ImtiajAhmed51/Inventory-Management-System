package imtiaj.repository;

import imtiaj.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private SessionFactory sessionFactory;

    public ProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Product sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(Product sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product sf = findById(id);
        session.delete(sf);
    }

    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> userQuery = session.createQuery("from Product", Product.class);
        return userQuery.getResultList();
    }

    public Product findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }
}
