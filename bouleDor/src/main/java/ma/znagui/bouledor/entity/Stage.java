package ma.znagui.bouledor.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.znagui.bouledor.enums.StageLevel;
import ma.znagui.bouledor.enums.StageType;
import ma.znagui.bouledor.enums.Status;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int roundNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    private StageType type;
    private StageLevel level;

    @ManyToOne
    private Tournament tournament;

    @OneToMany(mappedBy = "stage")
    private List<Challenge> challenges;

}
