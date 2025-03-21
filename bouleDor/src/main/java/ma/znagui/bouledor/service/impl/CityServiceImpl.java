package ma.znagui.bouledor.service.impl;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.city.CityResponseDTO;
import ma.znagui.bouledor.entity.City;
import ma.znagui.bouledor.exception.ResourceNotFoundExeption;
import ma.znagui.bouledor.mapper.CityMapper;
import ma.znagui.bouledor.repository.CityRepository;
import ma.znagui.bouledor.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;



    @Override
    public City getCityEntityById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Ville", id));
    }

    @Override
    public List<CityResponseDTO> getAllCities() {
        return cityRepository.findAll().stream().map(cityMapper::cityToResponseDTO).toList();

    }
}
