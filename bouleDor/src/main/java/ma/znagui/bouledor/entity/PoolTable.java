package ma.znagui.bouledor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class PoolTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate lastMaintenance;
    private Boolean isAvailable;
    private Boolean availableForTournaments;
    private String condition;
    private String brand;

    @ManyToOne
    private Club club;

}
