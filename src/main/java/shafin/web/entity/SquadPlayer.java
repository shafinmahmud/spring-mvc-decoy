package shafin.web.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author shafin
 * @since 11/28/17
 */
@Entity
@Table(name = "squad_player")
public class SquadPlayer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "generic_player_id")
    private int genericPlayerId;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "squad_id")
    private Squad squad;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "player_id")
    private Player player;

    @OneToOne(mappedBy = "squadPlayer", orphanRemoval = true, cascade = CascadeType.ALL)
    private PlayerStat playerStat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGenericPlayerId() {
        return genericPlayerId;
    }

    public void setGenericPlayerId(int genericPlayerId) {
        this.genericPlayerId = genericPlayerId;
    }

    public Squad getSquad() {
        return squad;
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PlayerStat getPlayerStat() {
        return playerStat;
    }

    public void setPlayerStat(PlayerStat playerStat) {
        this.playerStat = playerStat;
    }
}
