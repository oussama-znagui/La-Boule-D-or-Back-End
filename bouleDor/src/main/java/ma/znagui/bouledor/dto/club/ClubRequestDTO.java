package ma.znagui.bouledor.dto.club;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.entity.City;
import ma.znagui.bouledor.validation.api.CheckExistion;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ClubRequestDTO {
    @NotBlank(message = "Le nom du club SVP!")
    private String name;
    @NotBlank(message = "L'adresse du club SVP!")
    private String adresse;
//    @NotBlank(message = "La date de fondation du club SVP!")
    private LocalDate fondationDate;
    @NotNull(message = "La capacity du club SVP!")
    private int capacity;
    @NotNull(message = "La superficie du club SVP!")
    private Double area;
    @NotNull(message = "ID de la ville SVP!")
    @CheckExistion(entityC = City.class)
    private  Long city_id;


}
