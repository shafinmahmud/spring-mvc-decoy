package shafin.web.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author SHAFIN
 * @since 12/11/2016
 */
public abstract class GenericDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public Class<T> entityType;

    public GenericDao() {
        entityType = (Class) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public boolean doesExist(long id) {
        return getSession().get(entityType, id) != null;
    }

    public void saveOrUpdate(T entity) {
        getSession().persist(entity);
    }

    public T find(long id) {
        return (T) getSession().get(entityType, id);
    }

    public List<T> findAll() {
        Criteria criteria = getSession().createCriteria(entityType);
        List<T> allItemList = criteria.addOrder(Order.asc("id")).list();

        return allItemList;
    }

    public void update(T updatedEntity) {
        getSession().update(updatedEntity);
    }

    public void delete(long id) {
        T t = (T) getSession().createCriteria(entityType)
                .add(Restrictions.eq("id", id))
                .uniqueResult();

        if (t != null) {
            getSession().delete(t);
        }
    }

    public void delete(List<Long> ids) {

        for (Long id : ids) {
            T t = (T) getSession().createCriteria(entityType)
                    .add(Restrictions.eq("id", id))
                    .uniqueResult();

            if (t != null) {
                getSession().delete(t);
            }
        }
    }

    public void deleteAll() {
        getSession().createQuery("delete from " + entityType.getSimpleName())
                .executeUpdate();
    }

    public long countAll() {
        Long count = (Long) getSession().createCriteria(entityType)
                .setProjection(Projections.rowCount())
                .uniqueResult();

        return count;
    }
}
