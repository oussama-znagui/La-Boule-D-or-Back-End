package ma.znagui.bouledor.mapper;

import ma.znagui.bouledor.dto.club.ClubEmbdedDTO;
import ma.znagui.bouledor.dto.club.ClubRequestDTO;
import ma.znagui.bouledor.dto.club.ClubResponseDTO;
import ma.znagui.bouledor.entity.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClubMapper {

    @Mapping(target = "city.id", source = "city_id")
    Club createDTOtoClub(ClubRequestDTO dto);

    ClubResponseDTO clubToResponseDTO(Club club);

    ClubEmbdedDTO clubToEmbdedDTO(Club club);
}
