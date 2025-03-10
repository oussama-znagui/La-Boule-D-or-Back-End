package ma.znagui.bouledor.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ma.znagui.bouledor.validation.api.ValidDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatValidator implements ConstraintValidator<ValidDate, LocalDate> {


    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        System.out.println("alloooo");
        if (value == null) {
            return true;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            formatter.parse(value.toString());
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
