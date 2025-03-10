package ma.znagui.bouledor.dto.table;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class TableEmbdedDTO {
    private int id;
    private LocalDate lastMaintenance;
    private Boolean isAvailable;
    private Boolean availableForTournaments;
    private String condition;
    private String brand;
}
