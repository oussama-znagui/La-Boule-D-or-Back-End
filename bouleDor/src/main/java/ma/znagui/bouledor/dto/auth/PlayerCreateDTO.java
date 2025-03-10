package ma.znagui.bouledor.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerCreateDTO {

    @NotBlank(message = "Le prenom du Joueur SVP!")
    private String firstname;
    @NotBlank(message = "Le nom du Joueur SVP!")
    private String lastname;
    @NotBlank(message = "L'email du Joueur SVP!")
    private String email;
    @NotBlank(message = "Le mot de pass SVP!")
    private String password;
    @NotBlank(message = "Le N° CIN du Joueur SVP!")
    private String cin;
    @NotBlank(message = "Le prenom du Joueur SVP!")
    private String gameType;
    @NotBlank(message = "Le noveau du Joueur SVP!")
    private String level;


}
