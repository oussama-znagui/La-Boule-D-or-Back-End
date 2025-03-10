package ma.znagui.bouledor.dto.poolTable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.dto.club.ClubEmbdedDTO;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PoolTableResponseDTO {
    private int id;
    private int size;
    private LocalDate lastMaintenance;
    private Boolean isAvailable;
    private String condition;
    private String brand;
    private ClubEmbdedDTO club;
}
