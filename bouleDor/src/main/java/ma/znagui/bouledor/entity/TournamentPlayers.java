package ma.znagui.bouledor.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class TournamentPlayers  {

    @EmbeddedId
    TournamentPlayersKey id;

    @MapsId("tournament_id")
    @ManyToOne
    private Tournament tournament;

    @MapsId("player_id")
    @ManyToOne
    private Player player;

    private String note;


}
