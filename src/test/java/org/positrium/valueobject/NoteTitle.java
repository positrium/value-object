package org.positrium.valueobject;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class NoteTitle extends ValueObject<String> {
    @NotNull
    @Size(min = 1, max = 5)
    private String value;

    public NoteTitle(String value) {
        this.value = value;

        validate();
    }

    @Override
    public String value() {
        return this.value;
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
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

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
     *
     * @param other Object
     * @return boolean
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;

        if (!(other instanceof NoteTitle)) return false;

        NoteTitle that = (NoteTitle) other;
        return Objects.deepEquals(this.value, that.value);
    }
}
