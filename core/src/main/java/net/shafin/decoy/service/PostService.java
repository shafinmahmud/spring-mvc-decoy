package net.shafin.decoy.service;

import net.shafin.decoy.entity.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author shafin
 * @since 2/18/18
 */
@Repository
public class PostService {

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
