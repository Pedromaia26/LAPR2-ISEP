package app.domain.model;

public class ParameterCategory {

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
        if (name.trim().length() > 10)
            throw new IllegalArgumentException("Name must have no more than 10 characters");

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

    @Override
    public String toString() {
        return String.format("Name: %s; Code: %s", name, code);
    }
}
