package ma.znagui.bouledor.validation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ma.znagui.bouledor.exception.ResourceNotFoundExeption;
import ma.znagui.bouledor.validation.api.CheckExistion;

public class CheckExistingValidator implements ConstraintValidator<CheckExistion, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> entityC;

    public void initialize(CheckExistion constraintAnnotation) {
        this.entityC = constraintAnnotation.entityC();
    }
    public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
        if (aLong == null){
            return false;

        }
        Long count = (Long) entityManager.createQuery("SELECT COUNT(*) FROM " + entityC.getSimpleName() + " e WHERE e.id = :id ").setParameter("id",aLong).getSingleResult();

        if(count == 0){
            throw new ResourceNotFoundExeption(entityC.getSimpleName(),aLong);
        }
        return true;
    }
}
