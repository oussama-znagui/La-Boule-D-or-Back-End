package ma.znagui.bouledor.mapper;

import ma.znagui.bouledor.dto.auth.PlayerCreateDTO;
import ma.znagui.bouledor.dto.player.PlayerEmbdedDTO;
import ma.znagui.bouledor.dto.player.PlayerResponseDTO;
import ma.znagui.bouledor.entity.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMaper {

    Player createPlayerDTOtoPlayer(PlayerCreateDTO dto);

    PlayerResponseDTO playerToResponseDTO(Player player);
    PlayerEmbdedDTO playerToEmbdedDTO(Player player);
}
