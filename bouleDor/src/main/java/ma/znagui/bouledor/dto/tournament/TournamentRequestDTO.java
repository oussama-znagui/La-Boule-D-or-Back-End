package ma.znagui.bouledor.dto.tournament;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.enums.Level;
import ma.znagui.bouledor.enums.TounamentMode;
import ma.znagui.bouledor.enums.TournamentFormat;
import ma.znagui.bouledor.enums.TournamentType;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class TournamentRequestDTO {
    @NotBlank(message = "Le Titre du tournoi")
    protected String title;

    //    @EnumValidator(enumClass = TournamentType.class,message = "allo")
    protected TournamentType type;
    @NotNull(message = "le nombre du joueur (4 - 8 - 16 - 32 - 64 - 128)")
    @Min(2)
    protected int numberOfPlayers;

    protected LocalDate startDate;

    protected LocalDate endDate;
    @NotBlank(message = "Les regles du tournoi")
    protected String rules;
    @NotBlank(message = "Prize SVP!")
    protected String prize;


    private Level level;


    protected TounamentMode mode;

    protected TournamentFormat format;

    @NotNull(message = "Club d'hébergement SVP!")
    protected Long hostingClub_id;
}
