package ma.znagui.bouledor.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.individualTournament.individualTournamentRequestDTO;
import ma.znagui.bouledor.dto.individualTournament.individualTournamentResponseDTO;
import ma.znagui.bouledor.entity.IndividualTournament;
import ma.znagui.bouledor.service.IndividualTournamentService;
import ma.znagui.bouledor.validation.api.CheckExistion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/pool-individual-tournament")
public class IndividualTournamentController {
    private final IndividualTournamentService service;

    @PostMapping
    public ResponseEntity<individualTournamentResponseDTO> createPoolIndividualTournament(@Valid @RequestBody individualTournamentRequestDTO dto){
     return    ResponseEntity.ok(service.createIndividualTournament(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<individualTournamentResponseDTO> getPoolIndividualTournament(@CheckExistion(entityC = IndividualTournament.class) @PathVariable Long id){
        return ResponseEntity.ok(service.getOneIndividualTournament(id));
    }
}
