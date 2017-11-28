package shafin.web.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shafin
 * @since 11/28/17
 */
@Entity
@Table(name="squad")
public class Squad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    private String name;
    private String description;
    private String primaryFormation;

    @OneToMany(mappedBy = "squad")
    private Set<SquadPlayer> playerSet = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrimaryFormation() {
        return primaryFormation;
    }

    public void setPrimaryFormation(String primaryFormation) {
        this.primaryFormation = primaryFormation;
    }

    public Set<SquadPlayer> getPlayerSet() {
        return playerSet;
    }

    public void setPlayerSet(Set<SquadPlayer> playerSet) {
        this.playerSet = playerSet;
    }
}