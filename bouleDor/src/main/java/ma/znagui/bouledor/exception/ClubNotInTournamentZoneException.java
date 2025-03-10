package ma.znagui.bouledor.exception;

public class ClubNotInTournamentZoneException extends RuntimeException {
    public ClubNotInTournamentZoneException(String clubName,String zone) {
        super("Le club " + clubName + " n'existe pas a " + zone );
    }
}
