package app.domain.model;

public class ParameterCategory {

    private String name;
    private String code;


    public ParameterCategory (String name, String code){
        if (name.trim().length() > 10)
            throw new IllegalArgumentException("Name must have no more than 10 characters");

        this.name = name;

        if (code.trim().length() != 5)
            throw new IllegalArgumentException("The code must have 5 alphanumeric characters");

        this.code = code;

    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
