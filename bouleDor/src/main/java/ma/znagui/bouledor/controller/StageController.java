package ma.znagui.bouledor.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.stage.StageRequestDTO;
import ma.znagui.bouledor.dto.stage.StageResponseDTO;
import ma.znagui.bouledor.entity.Stage;
import ma.znagui.bouledor.service.StageService;
import ma.znagui.bouledor.validation.api.CheckExistion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/stages")
@CrossOrigin("http://localhost:4200")
public class StageController {
    private final StageService service;

    @PostMapping
    public ResponseEntity<StageResponseDTO> createStage(@Valid @RequestBody StageRequestDTO dto){
        return ResponseEntity.ok(service.createStage(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StageResponseDTO>  updateDtage(@CheckExistion(entityC = Stage.class) @PathVariable Long id, @Valid @RequestBody StageRequestDTO dto){
        return ResponseEntity.ok(service.updateStage(id,dto));
    }
}
