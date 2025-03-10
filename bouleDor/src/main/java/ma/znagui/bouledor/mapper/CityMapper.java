package ma.znagui.bouledor.mapper;

import ma.znagui.bouledor.dto.city.CityEmbdedDTO;
import ma.znagui.bouledor.entity.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityEmbdedDTO cityToEmbdedDTO(City city);
}
