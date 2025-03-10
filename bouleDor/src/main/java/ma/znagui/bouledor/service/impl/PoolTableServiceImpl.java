package ma.znagui.bouledor.service.impl;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.poolTable.PoolTableRequestDTO;
import ma.znagui.bouledor.dto.poolTable.PoolTableResponseDTO;
import ma.znagui.bouledor.entity.Club;
import ma.znagui.bouledor.entity.PoolTable;
import ma.znagui.bouledor.exception.MaxPoolTableCapacityReachedException;
import ma.znagui.bouledor.exception.ResourceNotFoundExeption;
import ma.znagui.bouledor.mapper.PoolTableMapper;
import ma.znagui.bouledor.repository.PoolTableRepository;
import ma.znagui.bouledor.service.ClubService;
import ma.znagui.bouledor.service.PoolTableService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PoolTableServiceImpl implements PoolTableService {
    private final PoolTableRepository poolTableRepository;
    private final PoolTableMapper poolTableMapper;
    private final ClubService clubService;


    public PoolTableResponseDTO createPoolTable(PoolTableRequestDTO dto) {
        PoolTable poolTable = poolTableMapper.requestDTOtoPoolTable(dto);
        Club club = clubService.getClubEntityById(poolTable.getClub().getId());
        poolTable.setClub(club);
        if (poolTable.getIsAvailable()){
            int availablePoolTablesCount =   club.getTables().stream().filter((PoolTable::getIsAvailable)).toList().size();
            if (club.getArea() < availablePoolTablesCount*10){
                    throw new MaxPoolTableCapacityReachedException(club.getName());
            }
        }
        return poolTableMapper.poolTableToResponseDTO(poolTableRepository.save(poolTable));
    }

    public PoolTableResponseDTO getOnePoolTable(Long id) {
        PoolTable poolTable = poolTableRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Table",id));
        return poolTableMapper.poolTableToResponseDTO(poolTable);
    }

    public String deletePoolTable(Long id) {
        PoolTable poolTable = poolTableRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Table",id));
        poolTableRepository.delete(poolTable);
        return "La table est supprimée avec succes.";
    }

    public PoolTableResponseDTO updatePoolTable(Long id, PoolTableRequestDTO dto) {
        return null;
    }
}
