package ma.znagui.bouledor.dto.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.dto.club.ClubEmbdedDTO;
import ma.znagui.bouledor.dto.stage.StageEmbdedDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersEmbdedDTO;
import ma.znagui.bouledor.enums.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class TournamentResponseDTO {
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
    protected TournamentFormat format;
    private Level level;
    private ClubEmbdedDTO hostingClub;
    private List<StageEmbdedDTO> stages;
    private List<TournamentPlayersEmbdedDTO> players;

}
