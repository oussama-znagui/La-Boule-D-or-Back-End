package ma.znagui.bouledor.service.impl;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.individualTournament.individualTournamentRequestDTO;
import ma.znagui.bouledor.dto.individualTournament.individualTournamentResponseDTO;
import ma.znagui.bouledor.entity.IndividualTournament;
import ma.znagui.bouledor.enums.Status;
import ma.znagui.bouledor.enums.TournamentFormat;
import ma.znagui.bouledor.exception.DatesAreNotValidException;
import ma.znagui.bouledor.exception.NumberOfPlayersIsInvalidException;
import ma.znagui.bouledor.exception.ResourceNotFoundExeption;
import ma.znagui.bouledor.mapper.IndividualTournamentMapper;
import ma.znagui.bouledor.repository.IndividualTournamentRepository;
import ma.znagui.bouledor.service.ClubService;
import ma.znagui.bouledor.service.IndividualTournamentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class IndividualTournamentServiceImpl implements IndividualTournamentService {
    private final IndividualTournamentRepository repository;
    private final IndividualTournamentMapper mapper;
    private final ClubService clubService;


    private Boolean verifyNumberOfPlayers(int n){
        while (n % 2 == 0){
            n = n/2;
        }
        return n == 1;

    }


    public individualTournamentResponseDTO createIndividualTournament(individualTournamentRequestDTO dto) {
        IndividualTournament poolIndividualTournament = mapper.RequestDTOtoPoolIndividualTournament(dto);

//        System.out.println(verifyNumberOfPlayers(poolIndividualTournament.getNumberOfPlayers()));

        if (poolIndividualTournament.getFormat() == TournamentFormat.KNOCKOUT){
            if (!verifyNumberOfPlayers(poolIndividualTournament.getNumberOfPlayers())){
                throw new NumberOfPlayersIsInvalidException();
            }

        }

        if (poolIndividualTournament.getFormat() == TournamentFormat.POINT_BASED && poolIndividualTournament.getNumberOfPlayers()%2 != 0){
            throw new NumberOfPlayersIsInvalidException(0);
        }


        if (poolIndividualTournament.getStartDate() == null && poolIndividualTournament.getEndDate() == null ){
                throw new DatesAreNotValidException();
        }else {
            if (poolIndividualTournament.getEndDate().isBefore(poolIndividualTournament.getStartDate()) || poolIndividualTournament.getStartDate().isBefore(LocalDate.now())) {
                throw new DatesAreNotValidException();
            }
        }

        poolIndividualTournament.setStatus(Status.SCHEDULED);

       poolIndividualTournament.setHostingClub(clubService.getClubEntityById(poolIndividualTournament.getHostingClub().getId()));

        return mapper.poolIndividualTournamentToResponseDTO(repository.save(poolIndividualTournament));
    }

    public individualTournamentResponseDTO getOneIndividualTournament(Long id) {
        IndividualTournament poolIndividualTournament = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("T",id));
        return mapper.poolIndividualTournamentToResponseDTO(poolIndividualTournament);
    }

    public individualTournamentResponseDTO updateIndividualTournament(Long id, individualTournamentRequestDTO dto) {
        return null;
    }
}
