package ma.znagui.bouledor.entity;

import jakarta.persistence.*;
import lombok.*;
import ma.znagui.bouledor.enums.GameType;
import ma.znagui.bouledor.enums.Level;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PLAYER")
@Entity
public class Player extends AppUser {
    private GameType gameType;
    private Level level;
    @ManyToOne
    @JoinColumn(name = "club_id", nullable = true)
    private Club club;

    @OneToMany(mappedBy = "player")
    private List<TournamentPlayers> tournaments;


    public List<TournamentPlayers> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<TournamentPlayers> tournaments) {
        this.tournaments = tournaments;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
