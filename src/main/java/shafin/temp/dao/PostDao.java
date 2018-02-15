package shafin.temp.dao;

import org.springframework.stereotype.Repository;
import shafin.temp.entity.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author shafin
 * @since 9/9/17
 */
@Repository
public class PostDao {

    @PersistenceContext
    private EntityManager em;

    public List<Post> findAll() {
        return em.createQuery("FROM Post p", Post.class)
                .getResultList();
    }

    @Transactional
    public Post save(Post post) {
        if (post.isNew()) {
            em.persist(post);
        } else {
            post = em.merge(post);
        }

        return post;
    }
}
