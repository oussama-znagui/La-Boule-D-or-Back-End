package ma.znagui.bouledor.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.auth.LoginRequestDTO;
import ma.znagui.bouledor.dto.auth.LoginResponseDTO;
import ma.znagui.bouledor.dto.auth.PlayerCreateDTO;
import ma.znagui.bouledor.dto.player.PlayerResponseDTO;
import ma.znagui.bouledor.service.AuthService;
import ma.znagui.bouledor.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Auth")
@AllArgsConstructor
public class AuthController {
    private final PlayerService playerService;
    private final AuthService authService;

    @PostMapping("/createPlayer")
    public ResponseEntity<PlayerResponseDTO> createPlayer(@Valid @RequestBody PlayerCreateDTO dto){
        return ResponseEntity.ok(playerService.createPlayer(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO dto){
        return ResponseEntity.ok(authService.authenticate(dto));
    }
}
