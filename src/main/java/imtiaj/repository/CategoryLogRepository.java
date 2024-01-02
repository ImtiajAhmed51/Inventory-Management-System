package imtiaj.repository;

import imtiaj.model.CategoryLogEntity;
import imtiaj.model.ProductLogEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryLogRepository {
    private SessionFactory sessionFactory;

    public CategoryLogRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(CategoryLogEntity sf) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sf);
    }

    public void edit(CategoryLogEntity sf) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sf);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        CategoryLogEntity sf = findById(id);
        session.delete(sf);
    }

    public List<CategoryLogEntity> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<CategoryLogEntity> userQuery = session.createQuery("from CategoryLogEntity", CategoryLogEntity.class);
        return userQuery.getResultList();
    }

    public CategoryLogEntity findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CategoryLogEntity.class, id);
    }
}
