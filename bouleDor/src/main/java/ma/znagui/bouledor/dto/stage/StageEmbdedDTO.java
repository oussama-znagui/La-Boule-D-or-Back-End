package ma.znagui.bouledor.dto.stage;


import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.enums.StageLevel;
import ma.znagui.bouledor.enums.StageType;
import ma.znagui.bouledor.enums.Status;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class StageEmbdedDTO {
    private Long id;
    private int roundNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    private StageType type;
    private StageLevel level;
}
