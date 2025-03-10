package ma.znagui.bouledor.exception;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException e){
        Map<String,String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ResourceNotFoundExeption.class)
    public ResponseEntity<String> handelResourceNotFoundExeption(ResourceNotFoundExeption e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> handelEmailAlreadyExistsException(EmailAlreadyExistsException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(MaxPoolTableCapacityReachedException.class)
    public ResponseEntity<String> handelMaxPoolTableCapacityReachedException(MaxPoolTableCapacityReachedException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(NumberOfPlayersIsInvalidException.class)
    public ResponseEntity<String> handelNumberOfPlayersIsInvalidException(NumberOfPlayersIsInvalidException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(DatesAreNotValidException.class)
    public ResponseEntity<String> handelDatesAreNotValidException(DatesAreNotValidException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InvalidTournamentTypeExcepion.class)
    public ResponseEntity<String> handelInvalidTournamentTypeExcepion(InvalidTournamentTypeExcepion e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(TournamentMaxClubsReachedException.class)
    public ResponseEntity<String> handelTournamentMaxClubsReachedException(TournamentMaxClubsReachedException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ClubNotInTournamentZoneException.class)
    public ResponseEntity<String> handelClubNotInTournamentZoneException(ClubNotInTournamentZoneException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(PlayerWithoutClubException.class)
    public ResponseEntity<String> handelPlayerWithoutClubException(PlayerWithoutClubException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }



    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<String> handelExpiredJwtException(ExpiredJwtException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(PlayerDoesNotBelongToAnyClubInTournamentException.class)
    public ResponseEntity<String> handelPlayerDoesNotBelongToAnyClubInTournamentException(PlayerDoesNotBelongToAnyClubInTournamentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(DatesAreNotCompatibleWithTournamentException.class)
    public ResponseEntity<String> handelDatesAreNotCompatibleWithTournamentException(DatesAreNotCompatibleWithTournamentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(DurationNotCompatibleWithTournamentException.class)
    public ResponseEntity<String> handelDurationNotCompatibleWithTournamentException(DurationNotCompatibleWithTournamentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
