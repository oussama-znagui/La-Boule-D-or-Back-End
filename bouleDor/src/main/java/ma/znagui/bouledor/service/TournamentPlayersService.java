package ma.znagui.bouledor.service;

import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersRequestDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersResponseDTO;

public interface TournamentPlayersService {
        TournamentPlayersResponseDTO addPlayerToTournament(TournamentPlayersRequestDTO dto);

}
