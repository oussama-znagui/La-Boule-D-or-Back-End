package ma.znagui.bouledor.controller;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.city.CityResponseDTO;
import ma.znagui.bouledor.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cities")
@CrossOrigin("http://localhost:4200")
public class CityController {
    private final CityService service;


    @GetMapping
    public ResponseEntity<List<CityResponseDTO>> getAll(){
        return ResponseEntity.ok(service.getAllCities());
    }
}
