package ma.znagui.bouledor.mapper;

import ma.znagui.bouledor.dto.poolClubsTournamentClubs.PoolClubsTournamentClubsRequestDTO;
import ma.znagui.bouledor.dto.poolClubsTournamentClubs.PoolClubsTournamentClubsResponseDTO;
import ma.znagui.bouledor.entity.PoolClubsTournamentClubs;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PoolClubsTournamentClubsMapper {


    @Mappings({
            @Mapping(target = "id.tournamentID", source = "tounament_id"),
            @Mapping(target = "id.clubID", source = "club_id"),
            @Mapping(target = "tournament.id", source = "tounament_id"),
            @Mapping(target = "club.id", source = "club_id"),
    })
    PoolClubsTournamentClubs toEntity(PoolClubsTournamentClubsRequestDTO dto);


    PoolClubsTournamentClubsResponseDTO toResponseDTO(PoolClubsTournamentClubs poolClubsTournamentClubs);
}
