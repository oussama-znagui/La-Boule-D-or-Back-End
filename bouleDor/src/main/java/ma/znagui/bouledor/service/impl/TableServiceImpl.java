package ma.znagui.bouledor.service.impl;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.table.TableRequestDTO;
import ma.znagui.bouledor.dto.table.TableResponseDTO;
import ma.znagui.bouledor.entity.PoolTable;
import ma.znagui.bouledor.mapper.TableMapper;
import ma.znagui.bouledor.repository.TableRepository;
import ma.znagui.bouledor.service.ClubService;
import ma.znagui.bouledor.service.TableService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TableServiceImpl implements TableService {
    private final TableRepository tableRepository;
    private final TableMapper tableMapper;
    private final ClubService clubService;



    public TableResponseDTO createTable(TableRequestDTO dto) {
        PoolTable table = tableMapper.toEntity(dto);
        table.setClub(clubService.getClubEntityById(table.getClub().getId()));

        return tableMapper.pooltableToResponseDTO(tableRepository.save(table));
    }

    public TableResponseDTO getPoolTableById(Long id) {
        return null;
    }

    public PoolTable getPoolTableEntityById(Long id) {
        return null;
    }

    public TableResponseDTO updateTable(Long id, TableRequestDTO dto) {
        return null;
    }

    public String deleteTable(Long id) {
        return "";
    }
}
