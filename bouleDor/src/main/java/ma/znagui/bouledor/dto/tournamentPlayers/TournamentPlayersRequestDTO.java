package ma.znagui.bouledor.dto.tournamentPlayers;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.entity.Player;
import ma.znagui.bouledor.entity.Tournament;
import ma.znagui.bouledor.validation.api.CheckExistion;

@Getter
@AllArgsConstructor
public class TournamentPlayersRequestDTO {
    @NotNull(message = "le joueur SVP!")
    @CheckExistion(entityC = Player.class)
    private Long player_id;

    @NotNull(message = "tournoi SVP!")
    @CheckExistion(entityC = Tournament.class)
    private Long tournement_id;

    private String note;
}
