package ma.znagui.bouledor.service;

import ma.znagui.bouledor.dto.poolTable.PoolTableRequestDTO;
import ma.znagui.bouledor.dto.poolTable.PoolTableResponseDTO;

public interface PoolTableService {
    PoolTableResponseDTO createPoolTable(PoolTableRequestDTO dto);
    PoolTableResponseDTO getOnePoolTable(Long id);
    String deletePoolTable(Long id);
    PoolTableResponseDTO updatePoolTable(Long id, PoolTableRequestDTO dto);
}
