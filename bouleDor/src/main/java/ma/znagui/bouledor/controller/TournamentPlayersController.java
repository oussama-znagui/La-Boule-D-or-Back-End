package ma.znagui.bouledor.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersRequestDTO;
import ma.znagui.bouledor.dto.tournamentPlayers.TournamentPlayersResponseDTO;
import ma.znagui.bouledor.service.TournamentPlayersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/tournament-players")
public class TournamentPlayersController {
    private final TournamentPlayersService service;


    @PostMapping
    public ResponseEntity<TournamentPlayersResponseDTO> addPlayerToTournament(@Valid @RequestBody TournamentPlayersRequestDTO dto){
        return ResponseEntity.ok(service.addPlayerToTournament(dto));
    }


}
