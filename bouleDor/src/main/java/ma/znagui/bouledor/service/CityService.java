package ma.znagui.bouledor.service;

import ma.znagui.bouledor.dto.city.CityResponseDTO;
import ma.znagui.bouledor.entity.City;

import java.util.List;

public interface CityService {
    City getCityEntityById(Long id);
    List<CityResponseDTO> getAllCities();
}
