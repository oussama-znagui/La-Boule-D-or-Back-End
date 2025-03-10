package ma.znagui.bouledor.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {

        super("l'email: " + email + " existe deja");
    }
}
