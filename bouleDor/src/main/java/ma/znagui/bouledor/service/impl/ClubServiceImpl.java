package ma.znagui.bouledor.service.impl;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.club.ClubRequestDTO;
import ma.znagui.bouledor.dto.club.ClubResponseDTO;
import ma.znagui.bouledor.entity.Club;
import ma.znagui.bouledor.exception.ResourceNotFoundExeption;
import ma.znagui.bouledor.mapper.ClubMapper;
import ma.znagui.bouledor.repository.ClubRepository;
import ma.znagui.bouledor.service.CityService;
import ma.znagui.bouledor.service.ClubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClubServiceImpl implements ClubService {
    private final ClubMapper clubMapper;
    private final ClubRepository clubRepository;
    private final CityService cityService;

    public ClubResponseDTO createClub(ClubRequestDTO dto) {

        Club club = clubMapper.createDTOtoClub(dto);
        club.setCity(cityService.getCityEntityById(club.getCity().getId()));
        Club created = clubRepository.save(club);
        return clubMapper.clubToResponseDTO(created);
    }

    public ClubResponseDTO getOneClub(Long id) {
        Club club = getClubEntityById(id);
        return clubMapper.clubToResponseDTO(club);
    }

    @Override
    public Page<ClubResponseDTO> getAllClubs(Pageable pageable) {
        return clubRepository.findAll(pageable)
                .map(clubMapper::clubToResponseDTO);
    }



    public ClubResponseDTO updateClub(Long id, ClubRequestDTO dto) {
        Club club = clubMapper.createDTOtoClub(dto);
        club.setId(id);
        clubRepository.save(club);
        return clubMapper.clubToResponseDTO(club);
    }



    public String deleteClub(Long id) {
        clubRepository.delete(getClubEntityById(id));
        return "Club Supprimé avec success";

    }


    public Club getClubEntityById(Long id) {
        return clubRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Club", id));
    }
}
