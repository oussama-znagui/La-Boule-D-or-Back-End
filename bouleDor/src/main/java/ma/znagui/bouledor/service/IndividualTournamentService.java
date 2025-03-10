package ma.znagui.bouledor.service;

import ma.znagui.bouledor.dto.individualTournament.individualTournamentRequestDTO;
import ma.znagui.bouledor.dto.individualTournament.individualTournamentResponseDTO;

public interface IndividualTournamentService {

    individualTournamentResponseDTO createIndividualTournament(individualTournamentRequestDTO dto);
    individualTournamentResponseDTO getOneIndividualTournament(Long id);
    individualTournamentResponseDTO updateIndividualTournament(Long id, individualTournamentRequestDTO dto);
    
}
