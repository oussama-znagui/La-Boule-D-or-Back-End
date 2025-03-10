package ma.znagui.bouledor.validation.api;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ma.znagui.bouledor.validation.EnumValidatorImpl;

import java.lang.annotation.*;




@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValidator {
    Class<? extends Enum<?>> enumClass();
    String message() default "doit être l'une des valeurs de l'énumération {enumClass}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
