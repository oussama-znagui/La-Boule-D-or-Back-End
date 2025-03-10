package ma.znagui.bouledor.dto.clubsTournament;

import ma.znagui.bouledor.dto.club.ClubEmbdedDTO;
import ma.znagui.bouledor.dto.stage.StageEmbdedDTO;
import ma.znagui.bouledor.dto.tournament.TournamentEmbdedDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersEmbdedDTO;
import ma.znagui.bouledor.enums.*;

import java.time.LocalDate;
import java.util.List;

public class ClubsTournamentEmbdedDTO extends TournamentEmbdedDTO {
    private int numberOfTeams;


    public ClubsTournamentEmbdedDTO(Long id, Level level, String title, TournamentType type, int numberOfPlayers, LocalDate startDate, LocalDate endDate, String rules, String prize, Status status, TounamentMode mode, TournamentFormat format, ClubEmbdedDTO hostingClub,int numberOfTeams) {
        super(id, level, title, type, numberOfPlayers, startDate, endDate, rules, prize, status, mode, format, hostingClub);
        this.numberOfTeams = numberOfTeams;
    }
}
