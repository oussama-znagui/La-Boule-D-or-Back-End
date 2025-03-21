package ma.znagui.bouledor.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.clubsTournament.ClubsTournamentRequestDTO;
import ma.znagui.bouledor.dto.clubsTournament.ClubsTournamentResponseDTO;
import ma.znagui.bouledor.entity.ClubsTournament;
import ma.znagui.bouledor.service.ClubsTournamentService;
import ma.znagui.bouledor.validation.api.CheckExistion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clubs-tournament")
@CrossOrigin("http://localhost:4200")

public class ClubsTournamentController {
    private final ClubsTournamentService service;


    @PostMapping
    public ResponseEntity<ClubsTournamentResponseDTO> createClubsTournament(@Valid @RequestBody ClubsTournamentRequestDTO dto){
        return ResponseEntity.ok(service.createClubsTournament(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubsTournamentResponseDTO> getOneClubTournament(@CheckExistion(entityC = ClubsTournament.class) @PathVariable Long id){
        return ResponseEntity.ok(service.getOneClubsTournament(id));
    }

    @GetMapping
    public ResponseEntity<List<ClubsTournamentResponseDTO>> getAllClubsTournaments(){
        return ResponseEntity.ok(service.getAllClubsTournaments());
    }
}
