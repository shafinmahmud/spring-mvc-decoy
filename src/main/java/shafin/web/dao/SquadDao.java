package shafin.web.dao;

import org.springframework.stereotype.Repository;
import shafin.web.entity.Squad;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author shafin
 * @since 11/28/17
 */
@Repository
public class SquadDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void saveSquad(Squad squad) {
        if (squad.getId() == 0) {
            em.persist(squad);
            em.flush();
        } else {
            em.merge(squad);
        }
    }
}
