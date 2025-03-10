package ma.znagui.bouledor.dto.tournamentPlayers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.dto.player.PlayerEmbdedDTO;
import ma.znagui.bouledor.dto.tournament.TournamentEmbdedDTO;

@Getter
@AllArgsConstructor
public class TournamentPlayersEmbdedDTO {
    private TournamentEmbdedDTO tournament;
    private PlayerEmbdedDTO player;
    private String note;
}
