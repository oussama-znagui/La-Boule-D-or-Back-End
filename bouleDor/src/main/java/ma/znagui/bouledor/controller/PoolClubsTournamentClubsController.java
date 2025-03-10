package ma.znagui.bouledor.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.poolClubsTournamentClubs.PoolClubsTournamentClubsRequestDTO;
import ma.znagui.bouledor.dto.poolClubsTournamentClubs.PoolClubsTournamentClubsResponseDTO;
import ma.znagui.bouledor.service.PoolClubsTournamentClubsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/pool-clubs-tournament-clubs")
public class PoolClubsTournamentClubsController {
    private final PoolClubsTournamentClubsService service;

    @PostMapping
    public ResponseEntity<PoolClubsTournamentClubsResponseDTO> addClubToClubsTournament(@Valid @RequestBody PoolClubsTournamentClubsRequestDTO dto){
        return ResponseEntity.ok(service.addClubToTournament(dto));

    }
}
