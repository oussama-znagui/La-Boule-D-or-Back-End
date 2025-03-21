package ma.znagui.bouledor.mapper;

import ma.znagui.bouledor.dto.challenge.ChallengeRequestDTO;
import ma.znagui.bouledor.dto.challenge.ChallengeResponseDTO;
import ma.znagui.bouledor.dto.city.CityResponseDTO;
import ma.znagui.bouledor.entity.Challenge;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ChallengeMapper {

    @Mappings({
            @Mapping(target = "poolTable.id" ,source = "table_id"),
            @Mapping(target = "stage.id", source = "stage_id")
    })
    Challenge requestDtoToChallenge(ChallengeRequestDTO dto);

    ChallengeResponseDTO toResponseDTO(Challenge challenge)

}
