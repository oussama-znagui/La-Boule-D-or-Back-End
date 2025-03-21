package ma.znagui.bouledor.service;

import ma.znagui.bouledor.dto.club.ClubRequestDTO;
import ma.znagui.bouledor.dto.club.ClubResponseDTO;
import ma.znagui.bouledor.entity.Club;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClubService {
    ClubResponseDTO createClub(ClubRequestDTO dto);
    ClubResponseDTO getOneClub(Long id);
    Page<ClubResponseDTO> getAllClubs(Pageable pageable);
    List<ClubResponseDTO> getAllClubs2();
    ClubResponseDTO updateClub(Long id, ClubRequestDTO dto);
    String deleteClub(Long id);
    Club getClubEntityById(Long id);

}
