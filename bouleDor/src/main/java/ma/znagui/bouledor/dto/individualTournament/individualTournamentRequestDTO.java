package ma.znagui.bouledor.dto.individualTournament;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ma.znagui.bouledor.dto.tournament.TournamentRequestDTO;
import ma.znagui.bouledor.enums.Level;
import ma.znagui.bouledor.enums.TounamentMode;
import ma.znagui.bouledor.enums.TournamentFormat;
import ma.znagui.bouledor.enums.TournamentType;

import java.time.LocalDate;

@Getter

public class individualTournamentRequestDTO extends TournamentRequestDTO {


    public individualTournamentRequestDTO(String title, TournamentType type, int numberOfPlayers, LocalDate startDate, LocalDate endDate, String rules, String prize, Level level, TounamentMode mode, TournamentFormat format, Long hostingClub_id) {
        super(title, type, numberOfPlayers, startDate, endDate, rules, prize, level, mode, format, hostingClub_id);
    }
}
