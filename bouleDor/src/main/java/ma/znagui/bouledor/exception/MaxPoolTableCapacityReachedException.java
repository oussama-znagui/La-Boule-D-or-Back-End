package ma.znagui.bouledor.exception;

public class MaxPoolTableCapacityReachedException extends RuntimeException {

    public MaxPoolTableCapacityReachedException(String club)
    {
        super("Le club : " + club + " atteint la capacite maximale des table disponible");
    }
}
