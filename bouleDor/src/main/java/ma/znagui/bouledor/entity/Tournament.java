package ma.znagui.bouledor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.znagui.bouledor.enums.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private TournamentType type;
    private int numberOfPlayers;
    private LocalDate startDate;
    private LocalDate endDate;
    private String rules;
    private String prize;
    private Status status;
    private TounamentMode mode;
    private TournamentFormat format;
    private Level level;


    @ManyToOne
    private Club hostingClub;

    @OneToMany(mappedBy = "tournament")
    private List<Stage> stages;

    @OneToMany(mappedBy = "tournament")
    private List<TournamentPlayers> players;



}
