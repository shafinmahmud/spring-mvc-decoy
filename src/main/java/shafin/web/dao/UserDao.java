package shafin.web.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import shafin.web.entity.User;

/**
 * @author SHAFIN
 * @since 12/11/2016
 */
@Repository(value = "userDao")
public class UserDao extends GenericDao<User> {

    public boolean doesExist(String name) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("name", name));
        Object user = criteria.uniqueResult();

        return user != null;
    }
}
