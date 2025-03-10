package ma.znagui.bouledor.dto.individualTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.dto.club.ClubEmbdedDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersEmbdedDTO;
import ma.znagui.bouledor.enums.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class individualTournamentResponseDTO {
    private Long id;
    private String title;
    private TournamentType type;
    private int numberOfPlayers;
    private LocalDate startDate;
    private LocalDate endDate;
    private String rules;
    private String prize;
    private Status status;
    private TounamentMode mode;
    private TournamentFormat format;
    private Level level;
    private ClubEmbdedDTO hostingClub;

    private List<TournamentPlayersEmbdedDTO> players;

}
