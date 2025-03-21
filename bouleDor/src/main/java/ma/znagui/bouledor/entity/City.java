package ma.znagui.bouledor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.znagui.bouledor.enums.Region;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Region region;

    @OneToMany(mappedBy = "city")
    private List<AppUser> users;



}
