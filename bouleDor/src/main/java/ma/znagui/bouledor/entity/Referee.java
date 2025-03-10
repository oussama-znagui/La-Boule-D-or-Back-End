package ma.znagui.bouledor.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.znagui.bouledor.enums.Level;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@DiscriminatorValue("REFEREE")
public class Referee extends AppUser {
    private Level experienceLevel;
    private String certification;
    private Boolean availability;


}
