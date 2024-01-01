package imtiaj.repository;
import imtiaj.model.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository{

    private SessionFactory sessionFactory;
    public CategoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void create(Category sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(Category sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Category sf = findById(id);
        session.delete(sf);
    }

    public List<Category> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> userQuery = session.createQuery("from Category", Category.class);
        return userQuery.getResultList();
    }

    public Category findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, id);
    }
}
