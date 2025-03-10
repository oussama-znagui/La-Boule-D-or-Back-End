package ma.znagui.bouledor.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class PoolClubsTournamentClubs {
    @EmbeddedId
    private PoolClubsTournamentClubsKey id;

    @MapsId("tournamentID")
    @ManyToOne
    private ClubsTournament tournament;

    @MapsId("clubID")
    @ManyToOne
    private Club club;

    private int numberOfPlayers;

    private Boolean isApproved;

    private String clubNotes;



}
