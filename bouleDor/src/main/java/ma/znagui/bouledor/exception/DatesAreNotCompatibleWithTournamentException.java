package ma.znagui.bouledor.exception;

import java.time.LocalDate;

public class DatesAreNotCompatibleWithTournamentException extends RuntimeException{

    public DatesAreNotCompatibleWithTournamentException(LocalDate startDate, LocalDate endDate){
        super("Les date ne sont pas compatible avec tournoi | SVP Date entre " + startDate + " et " + endDate);

    }
}
