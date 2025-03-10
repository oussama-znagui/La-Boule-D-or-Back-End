package ma.znagui.bouledor.mapper;

import ma.znagui.bouledor.dto.tournament.TournamentEmbdedDTO;
import ma.znagui.bouledor.entity.Tournament;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TournamentMapper {

    TournamentEmbdedDTO tournamentToEmbdedDTO(Tournament tournament);
}
