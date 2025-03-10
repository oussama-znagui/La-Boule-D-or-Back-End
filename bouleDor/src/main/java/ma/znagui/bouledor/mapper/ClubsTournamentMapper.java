package ma.znagui.bouledor.mapper;

import ma.znagui.bouledor.dto.clubsTournament.ClubsTournamentRequestDTO;
import ma.znagui.bouledor.dto.clubsTournament.ClubsTournamentResponseDTO;
import ma.znagui.bouledor.entity.ClubsTournament;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClubsTournamentMapper {

    @Mapping(target = "hostingClub.id", source = "hostingClub_id")
    ClubsTournament requestDTOtoClubsTOurnament(ClubsTournamentRequestDTO dto);

    ClubsTournamentResponseDTO clubsTournamentToResponseDTO(ClubsTournament clubsTournament);

}
