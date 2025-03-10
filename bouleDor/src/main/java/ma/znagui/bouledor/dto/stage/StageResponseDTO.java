package ma.znagui.bouledor.dto.stage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.dto.tournament.TournamentEmbdedDTO;
import ma.znagui.bouledor.enums.StageLevel;
import ma.znagui.bouledor.enums.StageType;
import ma.znagui.bouledor.enums.Status;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class StageResponseDTO {
    private Long id;
    private int roundNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    private StageType type;
    private StageLevel level;
    private TournamentEmbdedDTO tounament;
}
