package ma.znagui.bouledor.mapper;


import ma.znagui.bouledor.dto.stage.StageRequestDTO;
import ma.znagui.bouledor.dto.stage.StageResponseDTO;
import ma.znagui.bouledor.entity.Stage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StageMapper {

    @Mapping(target = "tournament.id", source = "tournament_id")
    Stage requestDTOtoStage(StageRequestDTO dto);

    StageResponseDTO stageToResponseDTO(Stage stage);
}
