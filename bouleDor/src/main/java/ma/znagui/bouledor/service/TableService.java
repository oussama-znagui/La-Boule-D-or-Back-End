package ma.znagui.bouledor.service;

import ma.znagui.bouledor.dto.table.TableRequestDTO;
import ma.znagui.bouledor.dto.table.TableResponseDTO;
import ma.znagui.bouledor.entity.PoolTable;

public interface TableService {
    TableResponseDTO createTable(TableRequestDTO dto);
    TableResponseDTO getPoolTableById(Long id);
    PoolTable getPoolTableEntityById(Long id);
    TableResponseDTO updateTable(Long id, TableRequestDTO dto);
    String deleteTable(Long id);

}
