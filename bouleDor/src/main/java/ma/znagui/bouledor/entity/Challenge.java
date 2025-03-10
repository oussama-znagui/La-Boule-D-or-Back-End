package ma.znagui.bouledor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int receTo;
    private LocalDateTime dateTime;

    @ManyToOne
    private PoolTable poolTable;

    @ManyToOne
    private Stage stage;

    @OneToMany(mappedBy = "challenge")
    private List<Match> matches;

}
