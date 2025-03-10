package ma.znagui.bouledor.exception;

public class NumberOfPlayersIsInvalidException extends RuntimeException {
    public NumberOfPlayersIsInvalidException() {
        super("le nombres des joueurs pour une competition doit etre [4,8,16,32,64, ...]");
    }
    public NumberOfPlayersIsInvalidException(int a) {
        super("le nombres des joueurs pour une competition : X2");
    }
}
