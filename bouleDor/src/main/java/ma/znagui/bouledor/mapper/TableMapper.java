package ma.znagui.bouledor.mapper;

import ma.znagui.bouledor.dto.table.TableEmbdedDTO;
import ma.znagui.bouledor.dto.table.TableRequestDTO;
import ma.znagui.bouledor.dto.table.TableResponseDTO;
import ma.znagui.bouledor.entity.PoolTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TableMapper {

    @Mapping(target = "club.id", source = "club_id")
    PoolTable toEntity(TableRequestDTO dto);

    TableResponseDTO pooltableToResponseDTO(PoolTable poolTable);

    TableEmbdedDTO pooltableToEmbdedDTO(PoolTable poolTable);

}
