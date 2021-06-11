package app.domain.model;

import java.io.Serializable;

public class ParameterCategory implements Serializable {

    /**
     * String that contains the parameter category name.
     */
    private String name;
    /**
     * String that contains the parameter category code.
     */
    private String code;


    /**
     * Constructs an instance of ParameterCategory receiving the name and the code.
     *
     * @param name The parameter category name
     * @param code The parameter category code
     */
    public ParameterCategory (String name, String code){

        if (name.trim().length() > 15)
            throw new IllegalArgumentException("Name must have no more than 15 characters");

        this.name = name;

        if (code.trim().length() != 5)
            throw new IllegalArgumentException("The code must have 5 alphanumeric characters");

        this.code = code;

    }




    /**
     * Returns the code of the parameter category.
     *
     * @return The code of the parameter category
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the name of the parameter category.
     *
     * @return The name of the parameter category
     */
    public String getName() {
        return name;
    }

    /**
     * Change the name of the parameter category.
     *
     * @param name The new name of the parameter category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Change the name of the parameter category.
     *
     * @param code The new code of the parameter category
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns the textual description of parameter category.
     * @return Characteristics of the parameter category
     */
    @Override
    public String toString() {
        return String.format("Name: %s; Code: %s", name, code);
    }

    /**
     * Compares the object that evokes the method with another
     * @param o The object to compare
     * @return True if objects are equal and false if different
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParameterCategory that = (ParameterCategory) o;
        return this.name.equals(that.name) && this.code.equals(that.code);
    }

}
