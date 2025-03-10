package ma.znagui.bouledor.exception;

public class TournamentMaxClubsReachedException extends RuntimeException {
    public TournamentMaxClubsReachedException(int teams) {
        super("Cette tournoi accepte que : " + teams + "Clubs");
    }
}
