package ma.znagui.bouledor.service;

import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersRequestDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersResponseDTO;

import java.util.List;

public interface TournamentPlayersService {
        TournamentPlayersResponseDTO addPlayerToTournament(TournamentPlayersRequestDTO dto);
        List<TournamentPlayersResponseDTO> addplayersToTournament(List<TournamentPlayersRequestDTO> dtos);

}
