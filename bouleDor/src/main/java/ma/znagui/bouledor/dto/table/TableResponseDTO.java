package ma.znagui.bouledor.dto.table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.dto.club.ClubEmbdedDTO;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class TableResponseDTO {

    private int id;
    private LocalDate lastMaintenance;
    private Boolean isAvailable;
    private Boolean availableForTournaments;
    private String condition;
    private String brand;
    private ClubEmbdedDTO club;
}
