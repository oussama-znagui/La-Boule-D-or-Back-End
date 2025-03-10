package ma.znagui.bouledor.service;

import lombok.AllArgsConstructor;
import ma.znagui.bouledor.dto.auth.LoginRequestDTO;
import ma.znagui.bouledor.dto.auth.LoginResponseDTO;
import ma.znagui.bouledor.entity.AppUser;
import ma.znagui.bouledor.repository.UserRepository;
import ma.znagui.bouledor.service.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public LoginResponseDTO authenticate(LoginRequestDTO dto){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
            );

            System.out.println("✅ Authentification réussie pour : " + dto.getEmail());

            AppUser user = userRepository.findByEmail(dto.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé : " + dto.getEmail()));

            String jwtToken = jwtService.generateToken(user);


            List<String> roles = user.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            return new LoginResponseDTO(jwtToken, jwtService.getExpirationTime(), roles.toString());

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Email ou mot de passe incorrect !");
        }
    }



}
