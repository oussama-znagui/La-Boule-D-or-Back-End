package ma.znagui.bouledor.dto.poolClubsTournamentClubs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.entity.Club;
import ma.znagui.bouledor.entity.ClubsTournament;
import ma.znagui.bouledor.validation.api.CheckExistion;

@Getter
@AllArgsConstructor
public class PoolClubsTournamentClubsRequestDTO {

    @NotNull(message = "ID du tournoi SVP!")
    @CheckExistion(entityC = ClubsTournament.class)
    private Long tounament_id;

    @NotNull(message = "ID du club SVP!")
    @CheckExistion(entityC = Club.class)
    private Long club_id;

    @Min(1)
    private int numberOfPlayers;

}
