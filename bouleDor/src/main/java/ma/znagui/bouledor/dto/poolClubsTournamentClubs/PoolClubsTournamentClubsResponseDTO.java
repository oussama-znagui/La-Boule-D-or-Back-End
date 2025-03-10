package ma.znagui.bouledor.dto.poolClubsTournamentClubs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.dto.club.ClubEmbdedDTO;
import ma.znagui.bouledor.dto.clubsTournament.ClubsTournamentEmbdedDTO;

@AllArgsConstructor
@Getter
public class PoolClubsTournamentClubsResponseDTO {
    private ClubEmbdedDTO club;
    private ClubsTournamentEmbdedDTO tournament;

    private int numberOfPlayers;

    private Boolean isApproved;

    private String clubNotes;
}
