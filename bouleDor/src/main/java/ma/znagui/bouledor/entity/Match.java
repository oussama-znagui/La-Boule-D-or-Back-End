package ma.znagui.bouledor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Duration duration;

    @ManyToOne
    private Challenge challenge;


    @ManyToOne
    private Player player1;

    @ManyToOne
    private Player player2;

    @ManyToOne
    private Player winner;

}
