package ma.znagui.bouledor.service;

import ma.znagui.bouledor.dto.auth.PlayerCreateDTO;
import ma.znagui.bouledor.dto.player.PlayerResponseDTO;
import ma.znagui.bouledor.entity.Player;

import java.util.List;

public interface PlayerService {
    PlayerResponseDTO createPlayer(PlayerCreateDTO dto);
    PlayerResponseDTO getPlayerById(Long id);
    List<PlayerResponseDTO> getAllPlayers();
//    PlayerResponseDTO updatePlayer(Long id, PlayerCreateDTO);
Player getPlayerEntityById(Long id);
    void deletePlayer(Long id);
}
