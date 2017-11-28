package shafin.web.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author shafin
 * @since 11/28/17
 */
@Entity
@Table(name = "player_stat")
public class PlayerStat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int performance;

    @OneToOne
    @JoinColumn(name = "squad_player_id")
    private SquadPlayer squadPlayer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public SquadPlayer getSquadPlayer() {
        return squadPlayer;
    }

    public void setSquadPlayer(SquadPlayer squadPlayer) {
        this.squadPlayer = squadPlayer;
    }
}
