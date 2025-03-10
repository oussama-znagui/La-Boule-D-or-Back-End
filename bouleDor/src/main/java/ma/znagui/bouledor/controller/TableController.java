package ma.znagui.bouledor.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.table.TableRequestDTO;
import ma.znagui.bouledor.dto.table.TableResponseDTO;
import ma.znagui.bouledor.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/tables")
public class TableController {
    private final TableService service;

    @PostMapping
    public ResponseEntity<TableResponseDTO> createTable(@Valid @RequestBody TableRequestDTO dto){
        return ResponseEntity.ok(service.createTable(dto));
    }
}
