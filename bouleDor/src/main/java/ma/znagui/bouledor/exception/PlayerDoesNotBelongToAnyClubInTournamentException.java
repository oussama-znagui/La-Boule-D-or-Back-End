package ma.znagui.bouledor.exception;

public class PlayerDoesNotBelongToAnyClubInTournamentException extends RuntimeException {

    public PlayerDoesNotBelongToAnyClubInTournamentException(String name,String clubNamne) {
        super("Le joueur " + name + " a appartient aucun club tournoi, Club du joueur " + clubNamne);
    }
}
