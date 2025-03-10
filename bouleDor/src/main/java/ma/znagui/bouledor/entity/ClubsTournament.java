package ma.znagui.bouledor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public  class ClubsTournament extends Tournament {
    private int numberOfTeams;

    @OneToMany(mappedBy = "tournament")
    private List<PoolClubsTournamentClubs> clubs;



}
