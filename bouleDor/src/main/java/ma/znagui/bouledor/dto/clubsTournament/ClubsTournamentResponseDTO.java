package ma.znagui.bouledor.dto.clubsTournament;


import lombok.Getter;
import ma.znagui.bouledor.dto.club.ClubEmbdedDTO;
import ma.znagui.bouledor.dto.poolClubsTournamentClubs.PoolClubsTournamentClubsEmbdedDTO;
import ma.znagui.bouledor.dto.stage.StageEmbdedDTO;
import ma.znagui.bouledor.dto.tournament.TournamentResponseDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersEmbdedDTO;
import ma.znagui.bouledor.enums.*;

import java.time.LocalDate;
import java.util.List;

@Getter
public class ClubsTournamentResponseDTO  extends TournamentResponseDTO {
    private int numberOfTeams;
    private List<PoolClubsTournamentClubsEmbdedDTO> clubs;


    public ClubsTournamentResponseDTO(Long id, String title, TournamentType type, int numberOfPlayers, LocalDate startDate, LocalDate endDate, String rules, String prize, Status status, TounamentMode mode, TournamentFormat format, Level level, ClubEmbdedDTO hostingClub, List<StageEmbdedDTO> stages, List<TournamentPlayersEmbdedDTO> players,int numberOfTeams,List<PoolClubsTournamentClubsEmbdedDTO> clubs) {
        super(id, title, type, numberOfPlayers, startDate, endDate, rules, prize, status, mode, format, level, hostingClub, stages, players);
        this.numberOfTeams = numberOfTeams;
        this.clubs = clubs;

    }
}
