package ma.znagui.bouledor.validation.api;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ma.znagui.bouledor.validation.DateFormatValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateFormatValidator.class)
public @interface ValidDate {

    String message() default "Date must be in the format YYYY-MM-DD";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
