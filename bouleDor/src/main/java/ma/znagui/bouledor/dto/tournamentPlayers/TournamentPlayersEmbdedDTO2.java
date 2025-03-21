package ma.znagui.bouledor.dto.tournamentPlayers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.dto.player.PlayerEmbdedDTO;
import ma.znagui.bouledor.dto.tournament.TournamentEmbdedDTO;


@Getter
@AllArgsConstructor
public class TournamentPlayersEmbdedDTO2 {
    private TournamentEmbdedDTO tournament;
    private String note;
}
