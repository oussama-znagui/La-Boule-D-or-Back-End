package ma.znagui.bouledor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String adresse;
    private LocalDate fondationDate;
    private int capacity;
    private Double area;

    @OneToMany(mappedBy = "club")
    private List<Player> players;

    @OneToMany(mappedBy = "club")
    private  List<PoolTable> tables;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "hostingClub")
    private List<Tournament> tournaments;

    @OneToMany(mappedBy = "club")
    private List<PoolClubsTournamentClubs> tournamentsPlayed;

}
