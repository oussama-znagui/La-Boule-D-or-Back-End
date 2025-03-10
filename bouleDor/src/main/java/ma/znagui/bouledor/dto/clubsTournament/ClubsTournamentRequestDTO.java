package ma.znagui.bouledor.dto.clubsTournament;


import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.dto.club.ClubEmbdedDTO;
import ma.znagui.bouledor.dto.stage.StageEmbdedDTO;
import ma.znagui.bouledor.dto.tournament.TournamentRequestDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersEmbdedDTO;
import ma.znagui.bouledor.enums.*;

import java.time.LocalDate;
import java.util.List;

@Getter
public class ClubsTournamentRequestDTO extends TournamentRequestDTO {

    @Min(4)
    private int numberOfTeams;


    public ClubsTournamentRequestDTO(String title, TournamentType type, int numberOfPlayers, LocalDate startDate, LocalDate endDate, String rules, String prize, Level level, TounamentMode mode, TournamentFormat format, Long hostingClub_id, int numberOfTeams) {
        super(title, type, numberOfPlayers, startDate, endDate, rules, prize, level, mode, format, hostingClub_id);
        this.numberOfTeams = numberOfTeams;
    }
}
