package ma.znagui.bouledor.dto.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor

public class PlayerResponseDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String cin;
    private String gameType;
    private String level;
}
