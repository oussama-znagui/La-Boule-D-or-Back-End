package ma.znagui.bouledor.service;

import ma.znagui.bouledor.dto.poolClubsTournamentClubs.PoolClubsTournamentClubsRequestDTO;
import ma.znagui.bouledor.dto.poolClubsTournamentClubs.PoolClubsTournamentClubsResponseDTO;
import ma.znagui.bouledor.entity.PoolClubsTournamentClubs;

public interface PoolClubsTournamentClubsService {
    PoolClubsTournamentClubsResponseDTO addClubToTournament(PoolClubsTournamentClubsRequestDTO dto);
}
