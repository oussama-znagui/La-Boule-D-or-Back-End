package ma.znagui.bouledor.dto.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ma.znagui.bouledor.dto.city.CityEmbdedDTO;
import ma.znagui.bouledor.dto.club.ClubEmbdedDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersEmbdedDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersEmbdedDTO2;

import java.util.List;

@Getter
@AllArgsConstructor

public class PlayerResponseDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private CityEmbdedDTO city;
    private String cin;
    private String gameType;
    private String level;
    private ClubEmbdedDTO club;
//    private List<TournamentPlayersEmbdedDTO2> tournaments;

}
