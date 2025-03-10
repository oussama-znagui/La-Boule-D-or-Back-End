package ma.znagui.bouledor.exception;

public class DurationNotCompatibleWithTournamentException extends RuntimeException {
    public DurationNotCompatibleWithTournamentException(int days) {
        super("Les Dates ne sont pas compatible avec le tournoi, Au moins : " + days + " Jours");
    }
}
