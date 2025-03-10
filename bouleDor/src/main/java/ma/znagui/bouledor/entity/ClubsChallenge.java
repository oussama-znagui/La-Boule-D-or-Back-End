package ma.znagui.bouledor.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ClubsChallenge extends Challenge{

    @ManyToOne
    private Club club1;

    @ManyToOne
    private Club club2;
}
