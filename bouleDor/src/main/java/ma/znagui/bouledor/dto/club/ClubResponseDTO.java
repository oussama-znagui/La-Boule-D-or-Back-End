package ma.znagui.bouledor.dto.club;


import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.dto.city.CityEmbdedDTO;
import ma.znagui.bouledor.dto.player.PlayerEmbdedDTO;
import ma.znagui.bouledor.dto.table.TableEmbdedDTO;
import ma.znagui.bouledor.entity.Player;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter


public class ClubResponseDTO {
    private Long id;
    private String name;
    private String adresse;
    private LocalDate fondationDate;
    private int capacity;
    private CityEmbdedDTO city;
    private Double area;
    private List<TableEmbdedDTO> tables;
    private List<PlayerEmbdedDTO> players;


}
