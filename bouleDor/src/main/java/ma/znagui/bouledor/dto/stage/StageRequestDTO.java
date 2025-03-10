package ma.znagui.bouledor.dto.stage;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.entity.Tournament;
import ma.znagui.bouledor.enums.StageLevel;
import ma.znagui.bouledor.enums.StageType;
import ma.znagui.bouledor.enums.Status;
import ma.znagui.bouledor.validation.api.CheckExistion;
import ma.znagui.bouledor.validation.api.ValidDate;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class StageRequestDTO {

    @NotNull(message = "le numero de phase SVP!")
    @Min(1)
    private int roundNumber;

    @ValidDate
    private LocalDate  startDate;

    @ValidDate(message = "aloo")
    private LocalDate endDate;


    @CheckExistion(entityC = Tournament.class)
    private Long tournament_id;
}

