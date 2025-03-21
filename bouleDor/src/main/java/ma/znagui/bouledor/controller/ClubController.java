package ma.znagui.bouledor.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.club.ClubRequestDTO;
import ma.znagui.bouledor.dto.club.ClubResponseDTO;
import ma.znagui.bouledor.entity.Club;
import ma.znagui.bouledor.service.ClubService;
import ma.znagui.bouledor.validation.api.CheckExistion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ClubController {

    private final ClubService clubService;

    @GetMapping("/{id}")
    public ResponseEntity<ClubResponseDTO> getOneClub(@CheckExistion(entityC = Club.class) @PathVariable Long id){
        return ResponseEntity.ok(clubService.getOneClub(id));
    }

    @GetMapping
    public ResponseEntity<Page<ClubResponseDTO>> getAllClubs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(clubService.getAllClubs(pageable));
    }

    @PostMapping()
    public ResponseEntity<ClubResponseDTO> createClub(@Valid @RequestBody ClubRequestDTO dto){
        return ResponseEntity.ok(clubService.createClub(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClub(@CheckExistion(entityC = Club.class) @PathVariable Long id){
        return ResponseEntity.ok(clubService.deleteClub(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClubResponseDTO> updateClub(@CheckExistion(entityC = Club.class) @PathVariable Long id, @Valid @RequestBody ClubRequestDTO dto){
        return ResponseEntity.ok(clubService.updateClub(id,dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClubResponseDTO>> getAllClub2(){
        return ResponseEntity.ok(clubService.getAllClubs2());
    }




}
