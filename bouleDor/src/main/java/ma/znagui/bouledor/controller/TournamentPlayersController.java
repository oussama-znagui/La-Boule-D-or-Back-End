package ma.znagui.bouledor.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersRequestDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersResponseDTO;
import ma.znagui.bouledor.service.TournamentPlayersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tournament-players")
@CrossOrigin("http://localhost:4200")
public class TournamentPlayersController {
    private final TournamentPlayersService service;


    @PostMapping
    public ResponseEntity<TournamentPlayersResponseDTO> addPlayerToTournament(@Valid @RequestBody TournamentPlayersRequestDTO dto){
        return ResponseEntity.ok(service.addPlayerToTournament(dto));
    }


    @PostMapping("/players")
    public ResponseEntity<List<TournamentPlayersResponseDTO>> addPlayersToTournament(@Valid @RequestBody List<TournamentPlayersRequestDTO> dtos){
        return ResponseEntity.ok(service.addplayersToTournament(dtos));
    }



}
