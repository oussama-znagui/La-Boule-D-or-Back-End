package ma.znagui.bouledor.exception;

public class TournamentMaxPlayersReachedException extends RuntimeException {
    public TournamentMaxPlayersReachedException(int players) {
        super("Cette tournoi accepte que : " + players + "joueurs");
    }
}
