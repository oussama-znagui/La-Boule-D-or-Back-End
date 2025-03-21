package ma.znagui.bouledor.dto.challenge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.dto.stage.StageEmbdedDTO;
import ma.znagui.bouledor.dto.table.TableEmbdedDTO;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ChallengeResponseDTO {
    private Long id;
    private int receTo;
    private LocalDateTime dateTime;
    private TableEmbdedDTO poolTable;
    private StageEmbdedDTO stage;

}
