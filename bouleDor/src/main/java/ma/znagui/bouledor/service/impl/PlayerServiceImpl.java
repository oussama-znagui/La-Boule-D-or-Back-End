package ma.znagui.bouledor.service.impl;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.auth.PlayerCreateDTO;
import ma.znagui.bouledor.dto.player.PlayerResponseDTO;
import ma.znagui.bouledor.entity.Player;
import ma.znagui.bouledor.exception.EmailAlreadyExistsException;
import ma.znagui.bouledor.exception.ResourceNotFoundExeption;
import ma.znagui.bouledor.mapper.PlayerMaper;
import ma.znagui.bouledor.repository.PlayerRepository;
import ma.znagui.bouledor.service.PlayerService;
import ma.znagui.bouledor.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.ReadOnlyBufferException;
import java.util.List;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final UserService userService;

    private final PasswordEncoder passwordEncoder;
    private final PlayerMaper playerMaper;


    @Override
    public PlayerResponseDTO createPlayer(PlayerCreateDTO dto) {
        if (!userService.checkEmailExesting(dto.getEmail())){
            throw new EmailAlreadyExistsException(dto.getEmail());
        }
        Player player = playerMaper.createPlayerDTOtoPlayer(dto);
        player.setPassword(passwordEncoder.encode(dto.getPassword()));
        return playerMaper.playerToResponseDTO(playerRepository.save(player));
    }

 public    Player getPlayerEntityById(Long id){
        return playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Joueur",id));


    }

    @Override
    public PlayerResponseDTO getPlayerById(Long id) {
        return null;
    }

    @Override
    public List<PlayerResponseDTO> getAllPlayers() {
        return List.of();
    }

    @Override
    public void deletePlayer(Long id) {

    }
}
