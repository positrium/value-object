package org.positrium.valueobject;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public abstract class ValueObject<T> {
    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    public abstract T value();

    protected void validate() throws InvalidateFieldException {
        Set<ConstraintViolation<ValueObject<T>>> violations = validator.validate(this);
        for (ConstraintViolation<ValueObject<T>> violation : violations){
            String msg = "Argument %s. but it was <%s>";
            throw new InvalidateFieldException(String.format(msg, violation.getMessage(), violation.getInvalidValue()));
        }
    }

    /**
     * returns this value object hashcode.
     * <pre>
     * {@code
     * @override
     * public int hashCode(){
     *     return Objects.hash(value);
     * }
     * }
     *
     * </pre>
     * @return hash code
     */
    @Override
    public abstract int hashCode();

    /**
     * returns this value object equals
     * <pre>
     * {@code
     *  public boolean equals(Object other){
     *      if(this == other) return true;
     *
     *      if(!(other instanceof E)) return false;
     *
     *      E that = (E) other;
     *      return Objects.deepEquals(this.value, that.value);
     *  }
     * }
     * </pre>
     * @param other Object
     * @return boolean
     */
    @Override
    public abstract boolean equals(Object other);
}
