package ma.znagui.bouledor.service.impl;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.entity.City;
import ma.znagui.bouledor.exception.ResourceNotFoundExeption;
import ma.znagui.bouledor.repository.CityRepository;
import ma.znagui.bouledor.service.CityService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;



    @Override
    public City getCityEntityById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Ville", id));
    }
}
