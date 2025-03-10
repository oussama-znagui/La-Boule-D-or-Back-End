package ma.znagui.bouledor.mapper;


import ma.znagui.bouledor.dto.poolTable.PoolTableRequestDTO;
import ma.znagui.bouledor.dto.poolTable.PoolTableResponseDTO;
import ma.znagui.bouledor.entity.PoolTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PoolTableMapper {
    @Mapping(target = "club.id", source = "club_id")
    PoolTable requestDTOtoPoolTable(PoolTableRequestDTO dto);
    PoolTableResponseDTO poolTableToResponseDTO(PoolTable poolTable);
}
