package ma.znagui.bouledor.service;

import ma.znagui.bouledor.dto.clubsTournament.ClubsTournamentRequestDTO;
import ma.znagui.bouledor.dto.clubsTournament.ClubsTournamentResponseDTO;
import ma.znagui.bouledor.entity.ClubsTournament;

public interface ClubsTournamentService {
    ClubsTournamentResponseDTO createClubsTournament(ClubsTournamentRequestDTO dto);
    ClubsTournamentResponseDTO getOneClubsTournament(Long id);
    ClubsTournament getClubsTournamentEntityById(Long id);
}
