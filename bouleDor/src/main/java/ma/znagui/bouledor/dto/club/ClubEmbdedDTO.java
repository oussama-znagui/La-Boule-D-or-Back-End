package ma.znagui.bouledor.dto.club;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.dto.city.CityEmbdedDTO;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ClubEmbdedDTO {
    private Long id;
    private String name;
    private String adresse;
    private LocalDate fondationDate;
    private int capacity;
    private Double area;
    private CityEmbdedDTO city;

}
