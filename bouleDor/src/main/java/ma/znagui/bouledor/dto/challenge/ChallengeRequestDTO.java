package ma.znagui.bouledor.dto.challenge;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.entity.PoolTable;
import ma.znagui.bouledor.entity.Stage;
import ma.znagui.bouledor.validation.api.CheckExistion;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ChallengeRequestDTO {
    @NotNull(message = "rece To SVP!")
    @Min(1)
    private int receTo;

    private LocalDateTime dateTime;

    @CheckExistion(entityC = PoolTable.class)
    private Long table_id;

    @CheckExistion(entityC = Stage.class)
    private Long stage_id;
}
