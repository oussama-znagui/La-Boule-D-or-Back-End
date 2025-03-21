package ma.znagui.bouledor.dto.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.enums.Region;

@AllArgsConstructor
@Getter
public class CityResponseDTO {
    private Long id;
    private String name;
    private Region region;
}
