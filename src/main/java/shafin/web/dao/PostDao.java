package shafin.web.dao;

import org.springframework.stereotype.Repository;

/**
 * @author shafin
 * @since 9/9/17
 */
@Repository
public class PostDao {

//    @Autowired
//    private SessionFactory sessionFactory;
//
//    private Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }
//
//    public List<Post> findAll() {
//        return getSession().createQuery("FROM Post p")
//                .list();
//    }
//
//    @Transactional
//    public Post save(Post post) {
//        if (post.isNew()) {
//            getSession().save(post);
//            getSession().getTransaction().commit();
//        } else {
//            getSession().merge(post);
//        }
//
//        return post;
//    }
}
