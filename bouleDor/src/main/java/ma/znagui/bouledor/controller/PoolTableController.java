package ma.znagui.bouledor.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.poolTable.PoolTableRequestDTO;
import ma.znagui.bouledor.dto.poolTable.PoolTableResponseDTO;
import ma.znagui.bouledor.entity.PoolTable;
import ma.znagui.bouledor.service.PoolTableService;
import ma.znagui.bouledor.validation.api.CheckExistion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/pool-table")
public class PoolTableController {
    private final PoolTableService poolTableService;

    @PostMapping
    public ResponseEntity<PoolTableResponseDTO> createPoolTable(@Valid @RequestBody PoolTableRequestDTO dto){
        return ResponseEntity.ok(poolTableService.createPoolTable(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoolTableResponseDTO> getPoolTable(@CheckExistion(entityC = PoolTable.class) @PathVariable Long id){
        return ResponseEntity.ok(poolTableService.getOnePoolTable(id));
    }
}
