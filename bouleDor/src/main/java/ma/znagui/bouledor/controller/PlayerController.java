package ma.znagui.bouledor.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.auth.PlayerCreateDTO;
import ma.znagui.bouledor.dto.player.PlayerResponseDTO;
import ma.znagui.bouledor.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class PlayerController {
    private final PlayerService service;


    @PostMapping
    public ResponseEntity<PlayerResponseDTO> createPlayer(@Valid @RequestBody PlayerCreateDTO dto){
        return ResponseEntity.ok(service.createPlayer(dto));
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponseDTO>> getAllPlayers(){
        return ResponseEntity.ok(service.getAllPlayers());
    }
}
