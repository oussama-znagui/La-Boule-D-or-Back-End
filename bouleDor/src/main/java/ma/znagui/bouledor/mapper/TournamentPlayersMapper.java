package ma.znagui.bouledor.mapper;

import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersEmbdedDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersEmbdedDTO2;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersRequestDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersResponseDTO;
import ma.znagui.bouledor.entity.TournamentPlayers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TournamentPlayersMapper {


    TournamentPlayersEmbdedDTO tournementPlayersToEmbdedDTO(TournamentPlayers tournamentPlayers);

    TournamentPlayersEmbdedDTO2 tournementPlayersToEmbdedDTO2(TournamentPlayers tournamentPlayers);

    TournamentPlayersResponseDTO tournementPlayersToResponseDTO(TournamentPlayers tournamentPlayers);


    @Mappings({
            @Mapping(target = "id.tournament_id", source = "tournement_id"),
            @Mapping(target = "id.player_id", source = "player_id"),
            @Mapping(target = "tournament.id", source = "tournement_id"),
            @Mapping(target = "player.id", source = "player_id"),

    })

    TournamentPlayers requestDTOtoTournamentPlayers(TournamentPlayersRequestDTO dto);
}
