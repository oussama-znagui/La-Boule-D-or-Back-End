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
import ma.znagui.bouledor.exception.ResourceNotFoundExeption;
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
        List<Stage> stages = new ArrayList<Stage>();

        long totalDays =  ChronoUnit.DAYS.between(tournament.getStartDate(),tournament.getEndDate()) + 1;


        if ( tournament.getFormat() == TournamentFormat.POINT_BASED){

            int totalStage = 0;
            if(tournament instanceof ClubsTournament ){
                totalStage = ((ClubsTournament) tournament).getNumberOfTeams() - 1;
            }
            if (tournament instanceof IndividualTournament){
                totalStage =  tournament.getNumberOfPlayers() - 1;
            }





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


                        stageRepository.save(stage);
                    }

                    currentDate = currentDate.plusDays(1);
                }
            }

        }

        if (tournament.getFormat() == TournamentFormat.KNOCKOUT){
            int totalStage = 0;

            //nombre de stgs
            if(tournament instanceof ClubsTournament ){
                totalStage = (int) (Math.log(((ClubsTournament) tournament).getNumberOfTeams()) / Math.log(2));
            }
            if (tournament instanceof IndividualTournament){

                totalStage = (int) (Math.log( tournament.getNumberOfPlayers() ) / Math.log(2));
            }



            //Days

            if (totalStage <= totalDays){
                double interval = (double) totalDays / totalStage;
                double currentDayOffset = 0;


                for (int i = 0; i < totalStage; i++) {

                    LocalDate stageDate = tournament.getStartDate().plusDays((long) Math.round(currentDayOffset));
                    System.out.println(stageDate+  "zelkfjezl ezl izel fze le");
                    Stage stage = new Stage();
                    stage.setRoundNumber(i + 1);
                    stage.setStatus(Status.SCHEDULED);
                    stage.setType(StageType.KNOCKOUT);
                    stage.setLevel(getStageLeve(i));

                    stage.setTournament(tournament);
                    stage.setStartDate(stageDate);

                    stages.add(stage);



                    stageRepository.save(stage);

                    currentDayOffset += interval;
                }

            }else {
                int baseStagesPerDay = totalStage / (int) totalDays;
                int extraStages = totalStage % (int) totalDays;
                LocalDate currentDate = tournament.getStartDate();

                for (int i = 0; i < totalDays; i++) {
                    int stagesToday = baseStagesPerDay + (extraStages > 0 ? 1 : 0);
                    extraStages--;

                    for (int j = 0; j < stagesToday; j++) {
                        Stage stage = new Stage();
                        stage.setRoundNumber(i + 1);
                        stage.setStatus(Status.SCHEDULED);
                        stage.setType(StageType.KNOCKOUT);
                        stage.setLevel(getStageLeve(i));
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

        return stages;
    }

    private StageLevel getStageLeve(int s){
        switch (s){
            case 0:
                return StageLevel.FINAL_ELIMINATION;

            case 1:
                return StageLevel.SEMIFINAL_ELIMINATION;
            case 2:
                return StageLevel.QUARTERFINAL_ELIMINATION;

            case 3:
                return StageLevel.ROUND_OF_16_ELIMINATION;

            case 4:
                return StageLevel.ROUND_OF_32_ELIMINATION;

            case 5:
                return StageLevel.ROUND_OF_64_ELIMINATION;

            case 6:
                return StageLevel.ROUND_OF_128_ELIMINATION;

            default:
                return StageLevel.QUALIFICATION_ROUNDS;


        }


    }


    public StageResponseDTO createStage(StageRequestDTO dto) {
        Stage stage = stageMapper.requestDTOtoStage(dto);

        if (stage.getStartDate() == null ){
            throw new DatesAreNotValidException();
        }
//        if (stage.getStartDate().isAfter(stage.getEndDate())){
//            throw new DatesAreNotValidException();
//        }

        Tournament tournament = tournamentService.getTournamentEntityById(stage.getTournament().getId());


        if (tournament.getStartDate().isAfter(stage.getStartDate())){
            throw new DatesAreNotCompatibleWithTournamentException(tournament.getStartDate(),tournament.getEndDate());
        }



        stage.setType(StageType.valueOf(tournament.getFormat().name()));
        if (stage.getStatus() == null){
            stage.setStatus(Status.SCHEDULED);
        }

   Stage    created = stageRepository.save(stage);
        created.setTournament(tournament);

        System.out.println(created.getTournament());
        return stageMapper.stageToResponseDTO(created);
    }

    public StageResponseDTO getOneStage(Long id) {
        return null;
    }

    public StageResponseDTO updateStage(Long id, StageRequestDTO dto) {
       Stage stageToUpdate = stageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Phase",id));
       stageToUpdate.setRoundNumber(dto.getRoundNumber());
        stageToUpdate.setStartDate(dto.getStartDate());
        stageToUpdate.setStatus(dto.getStatus());
        stageToUpdate.setLevel(dto.getLevel());
      stageRepository.save(stageToUpdate);



        return stageMapper.stageToResponseDTO(stageToUpdate);
    }



    public String deleteStage(Long id) {
        Stage stageToDelete = stageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Phase",id));
        stageRepository.delete(stageToDelete);
        return "Deleted";
    }



}
