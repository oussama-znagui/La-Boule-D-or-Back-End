package ma.znagui.bouledor.service;

import ma.znagui.bouledor.dto.stage.StageRequestDTO;
import ma.znagui.bouledor.dto.stage.StageResponseDTO;
import ma.znagui.bouledor.entity.Stage;
import ma.znagui.bouledor.entity.Tournament;

import java.util.List;

public interface StageService {
    StageResponseDTO createStage(StageRequestDTO dto);
    StageResponseDTO getOneStage(Long id);
    StageResponseDTO updateStage(Long id,StageRequestDTO dto);
    String deleteStage(Long id);
    List<Stage> generateTournamentStages(Tournament tournament);


}
