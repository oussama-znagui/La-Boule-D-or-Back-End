package ma.znagui.bouledor.mapper;

import ma.znagui.bouledor.dto.individualTournament.individualTournamentRequestDTO;
import ma.znagui.bouledor.dto.individualTournament.individualTournamentResponseDTO;
import ma.znagui.bouledor.entity.IndividualTournament;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IndividualTournamentMapper {

    @Mapping(target = "hostingClub.id", source = "hostingClub_id")
    IndividualTournament RequestDTOtoPoolIndividualTournament(individualTournamentRequestDTO dto);

//    @Mapping(target = "")
    individualTournamentResponseDTO poolIndividualTournamentToResponseDTO(IndividualTournament poolIndividualTournament);
}
