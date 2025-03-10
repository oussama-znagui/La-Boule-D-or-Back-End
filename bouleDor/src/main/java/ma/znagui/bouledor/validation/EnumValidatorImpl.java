package ma.znagui.bouledor.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ma.znagui.bouledor.validation.api.EnumValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, Enum<?>> {
    private Set<Enum<?>> acceptedValues;

    @Override
    public void initialize(EnumValidator annotation) {
        Class<? extends Enum<?>> enumClass = annotation.enumClass();
        acceptedValues = Stream.of(enumClass.getEnumConstants())
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return acceptedValues.contains(value);
    }



}





