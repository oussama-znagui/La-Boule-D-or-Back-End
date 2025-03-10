package ma.znagui.bouledor.dto.city;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.znagui.bouledor.enums.Region;

@AllArgsConstructor

@Getter

public class CityEmbdedDTO {

    private Long id;
    private String name;
    private Region region;

}

