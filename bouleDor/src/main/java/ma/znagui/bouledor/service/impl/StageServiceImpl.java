package ma.znagui.bouledor.service.impl;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.stage.StageRequestDTO;
import ma.znagui.bouledor.dto.stage.StageResponseDTO;
import ma.znagui.bouledor.entity.ClubsTournament;
import ma.znagui.bouledor.entity.IndividualTournament;
import ma.znagui.bouledor.entity.Stage;
import ma.znagui.bouledor.entity.Tournament;
import ma.znagui.bouledor.enums.StageLevel;
import ma.znagui.bouledor.enums.StageType;
import ma.znagui.bouledor.enums.Status;
import ma.znagui.bouledor.enums.TournamentFormat;
import ma.znagui.bouledor.exception.DatesAreNotCompatibleWithTournamentException;
import ma.znagui.bouledor.exception.DatesAreNotValidException;
import ma.znagui.bouledor.mapper.StageMapper;
import ma.znagui.bouledor.repository.StageRepository;
import ma.znagui.bouledor.service.StageService;
import ma.znagui.bouledor.service.TournamentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class StageServiceImpl implements StageService {
    private final StageRepository stageRepository;
    private final StageMapper stageMapper;
    private final TournamentService tournamentService;





    public List<Stage> generateTournamentStages(Tournament tournament) {
        List<Stage> stages = new ArrayList<>();




        if ( tournament.getFormat() == TournamentFormat.POINT_BASED){

            int totalStage = 0;
            if(tournament instanceof ClubsTournament ){
                totalStage = ((ClubsTournament) tournament).getNumberOfTeams() - 1;
            }
            if (tournament instanceof IndividualTournament){
                totalStage =  tournament.getNumberOfPlayers() - 1;
            }




            long totalDays =  ChronoUnit.DAYS.between(tournament.getStartDate(),tournament.getEndDate()) + 1;
            System.out.println(totalDays);


            if (totalStage <= totalDays){
                double interval = (double) totalDays / totalStage;
                double currentDayOffset = 0;

                for (int i = 0; i < totalStage; i++) {
                    LocalDate stageDate = tournament.getStartDate().plusDays((long) Math.round(currentDayOffset));

                    Stage stage = new Stage();
                    stage.setRoundNumber(i + 1);
                    stage.setStatus(Status.SCHEDULED);
                    stage.setType(StageType.POINT_BASED);
                    stage.setLevel(StageLevel.POINTS_STAGE_GROUP);
                    stage.setTournament(tournament);
                    stage.setStartDate(stageDate);
                    stages.add(stage);
                    stageRepository.save(stage);

                    currentDayOffset += interval;
                }

            }else {
                int baseMatchesPerDay = totalStage / (int) totalDays;
                int extraMatches = totalStage % (int) totalDays;
                LocalDate currentDate = tournament.getStartDate();

                for (int i = 0; i < totalDays; i++) {
                    int matchesToday = baseMatchesPerDay + (extraMatches > 0 ? 1 : 0);
                    extraMatches--;

                    for (int j = 0; j < matchesToday; j++) {
                        Stage stage = new Stage();
                        stage.setRoundNumber(i + 1);
                        stage.setStatus(Status.SCHEDULED);
                        stage.setType(StageType.POINT_BASED);
                        stage.setLevel(StageLevel.POINTS_STAGE_GROUP);
                        stage.setTournament(tournament);
                        stage.setStartDate(currentDate);
                        stages.add(stage);

//                System.out.println(stage);

                        stageRepository.save(stage);
                    }

                    currentDate = currentDate.plusDays(1);
                }
            }

        }

        if (tournament.getFormat() == TournamentFormat.KNOCKOUT){


        }

        return stages;
    }


    public StageResponseDTO createStage(StageRequestDTO dto) {
        Stage stage = stageMapper.requestDTOtoStage(dto);

        if (stage.getStartDate() == null || stage.getEndDate() ==null){
            throw new DatesAreNotValidException();
        }
        if (stage.getStartDate().isAfter(stage.getEndDate())){
            throw new DatesAreNotValidException();
        }

        Tournament tournament = tournamentService.getTournamentEntityById(stage.getTournament().getId());

        if (tournament.getStartDate().isAfter(stage.getStartDate()) || tournament.getEndDate().isBefore(stage.getEndDate())){
            throw new DatesAreNotCompatibleWithTournamentException(tournament.getStartDate(),tournament.getEndDate());
        }





        return null;
    }

    public StageResponseDTO getOneStage(Long id) {
        return null;
    }

    public StageResponseDTO updateStage(StageRequestDTO dto) {
        return null;
    }

    public String deleteStage(Long id) {
        return "";
    }



}
