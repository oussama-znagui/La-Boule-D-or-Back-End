package ma.znagui.bouledor.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor

@ToString
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends AppUser{


}
