package shafin.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shafin.web.dao.UserDao;
import shafin.web.entity.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author SHAFIN
 * @since 12/11/2016
 */
@Service(value = "userService")
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAllUser() {

        return userDao.findAll();
    }

    public void insertUser(User user) {

        if (!userDao.doesExist(user.getName())) {
            userDao.saveOrUpdate(user);
        }
    }
}
