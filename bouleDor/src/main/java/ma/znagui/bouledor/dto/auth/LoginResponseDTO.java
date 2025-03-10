package ma.znagui.bouledor.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponseDTO {
    private String token;
    private long expiresIn;
    private String role;

}
