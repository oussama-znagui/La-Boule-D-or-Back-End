package ma.znagui.bouledor.dto.table;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.entity.Club;
import ma.znagui.bouledor.validation.api.CheckExistion;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class TableRequestDTO {

    private LocalDate lastMaintenance;

    @NotNull(message = "La table et Disponible ??")
    private Boolean isAvailable;

    @NotNull(message = "La table et Disponible pour tournoi ??")
    private Boolean availableForTournaments;

    @NotBlank(message = "Les condition de table SVP ! ")
    private String condition;

    @NotBlank(message = "La marque du table svp")
    private String brand;

    @NotNull(message = "Le club SVP ! ")
    @CheckExistion(entityC = Club.class)
    private Long club_id;

}
