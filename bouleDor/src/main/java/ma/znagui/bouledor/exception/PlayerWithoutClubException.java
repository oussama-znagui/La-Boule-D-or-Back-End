package ma.znagui.bouledor.exception;

public class PlayerWithoutClubException extends RuntimeException {

    public PlayerWithoutClubException(String name) {

        super("Le joueur " + name + " n'a pas de club");
    }
}
