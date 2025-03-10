package ma.znagui.bouledor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@DiscriminatorColumn(name="ROLE", discriminatorType = DiscriminatorType.STRING)
public abstract class  AppUser  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String firstname;
    protected String lastname;
    protected String email;
    protected String password;
    protected String cin;


    @ManyToOne
    protected City city;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = this.getClass().getAnnotation(DiscriminatorValue.class).value();
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));

    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
