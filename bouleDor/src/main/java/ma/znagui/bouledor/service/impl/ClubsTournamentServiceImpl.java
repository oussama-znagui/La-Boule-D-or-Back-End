package ma.znagui.bouledor.service.impl;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.clubsTournament.ClubsTournamentRequestDTO;
import ma.znagui.bouledor.dto.clubsTournament.ClubsTournamentResponseDTO;
import ma.znagui.bouledor.entity.ClubsTournament;
import ma.znagui.bouledor.enums.TournamentFormat;
import ma.znagui.bouledor.enums.TournamentType;
import ma.znagui.bouledor.enums.Status;
import ma.znagui.bouledor.exception.*;
import ma.znagui.bouledor.mapper.ClubsTournamentMapper;
import ma.znagui.bouledor.repository.ClubsTournamentRepository;
import ma.znagui.bouledor.service.ClubService;
import ma.znagui.bouledor.service.ClubsTournamentService;
import ma.znagui.bouledor.service.StageService;
import ma.znagui.bouledor.service.TournamentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@AllArgsConstructor
@Service
public class ClubsTournamentServiceImpl implements ClubsTournamentService {
    private final ClubsTournamentRepository clubsTournamentRepository;
    private final ClubsTournamentMapper clubsTournamentMapper;
    private final ClubService clubService;
    private final StageService stageService;
    private final TournamentService tournamentService;


    public ClubsTournamentResponseDTO createClubsTournament(ClubsTournamentRequestDTO dto) {
        ClubsTournament clubsTournament = clubsTournamentMapper.requestDTOtoClubsTOurnament(dto);






        if (clubsTournament.getType() == TournamentType.CLUB_LEVEL){
            throw new InvalidTournamentTypeExcepion("tournoi des club ne peux pas etre creer avec le type CLUB_LEVEL ");
        }


        if (clubsTournament.getStartDate() == null && clubsTournament.getEndDate() == null ){
            throw new DatesAreNotValidException();
        }else {
            if (clubsTournament.getEndDate().isBefore(clubsTournament.getStartDate()) || clubsTournament.getStartDate().isBefore(LocalDate.now())) {
                throw new DatesAreNotValidException();
            }
        }

        if (!verifyNumberOfTeams(clubsTournament.getNumberOfTeams()) && clubsTournament.getFormat() == TournamentFormat.KNOCKOUT){
            throw new NumberOfPlayersIsInvalidException();

        }
        if (clubsTournament.getFormat() == TournamentFormat.POINT_BASED && clubsTournament.getNumberOfTeams()%2 != 0){
            throw new NumberOfPlayersIsInvalidException(0);
        }

        clubsTournament.setStatus(Status.SCHEDULED);

        clubsTournament.setHostingClub(clubService.getClubEntityById(clubsTournament.getHostingClub().getId()));



        int possibleDays = tournamentService.isTournamentDurationValid(clubsTournament);
        System.out.println(possibleDays);
        if (ChronoUnit.DAYS.between(clubsTournament.getStartDate(), clubsTournament.getEndDate()) < possibleDays){
            throw new DurationNotCompatibleWithTournamentException(possibleDays);
        }

        ClubsTournament created = clubsTournamentRepository.save(clubsTournament);
        clubsTournament.setStages(stageService.generateTournamentStages(created));





        return clubsTournamentMapper.clubsTournamentToResponseDTO(created);
    }




    public ClubsTournamentResponseDTO getOneClubsTournament(Long id) {
        ClubsTournament clubsTournament = clubsTournamentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Club Tournament",id));
        return clubsTournamentMapper.clubsTournamentToResponseDTO(clubsTournament);
    }


    public ClubsTournament getClubsTournamentEntityById(Long id) {
        return clubsTournamentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Club Tournament",id));
    }

    @Override
    public List<ClubsTournamentResponseDTO> getAllClubsTournaments() {
        return clubsTournamentRepository.findAll().stream().map(clubsTournamentMapper::clubsTournamentToResponseDTO).toList();
    }


    private Boolean verifyNumberOfTeams(int n){
        while (n % 2 == 0){
            n = n/2;
        }
        return n == 1;

    }
}
