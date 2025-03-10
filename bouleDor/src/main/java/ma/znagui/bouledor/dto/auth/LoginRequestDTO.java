package ma.znagui.bouledor.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginRequestDTO {
    @NotBlank(message = "L'email SVP")
    private String email;
    @NotBlank(message = "Le Mot de pass SVP")
    private String password;
}
