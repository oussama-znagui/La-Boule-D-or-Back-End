package ma.znagui.bouledor.dto.poolTable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.entity.Club;
import ma.znagui.bouledor.validation.api.CheckExistion;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PoolTableRequestDTO {
    @NotNull(message = "La taille du table SVP!")
    private int size;
    private LocalDate lastMaintenance;
    @NotNull(message = "La disponibilité du table")
    private Boolean isAvailable;
    @NotBlank(message = "Les condition SVP")
    private String condition;
    @NotBlank(message = "La marque de la table SVP")
    private String brand;
    @NotNull(message = "ID du club SVP")
    @CheckExistion(entityC = Club.class)
    private Long club_id;
}
