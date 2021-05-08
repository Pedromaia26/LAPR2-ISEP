package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ParameterStore {

    /**
     * List that contains the parameters.
     */
    private List<Parameter> parameterList = new ArrayList<>();


    /**
     * Create a new parameter with the attributes received.
     *
     * @param code The parameter code
     * @param shortName The parameter short name
     * @param description The parameter description
     * @param category The parameter category
     * @return The parameter created
     */
    public Parameter createParameter(String code, String shortName, String description, ParameterCategory category){
        return new Parameter(code, shortName, description, category);
    }

    /**
     * Validates the parameter received.
     * @param parameter The parameter to be validate
     * @return True if the parameter is successfully validated, false if it is not
     */
    public boolean validateParameter(Parameter parameter){
        if (parameter == null){
            return false;
        }
        return (!(this.parameterList.contains(parameter)));
    }

    /**
     * Save the parameter received in the parameter list
     * @param parameter The parameter to be saved
     * @return True if the parameter is successfully added, false if it is not
     */
    public boolean saveParameter(Parameter parameter) {
        if (!validateParameter(parameter))
            return false;
        return this.parameterList.add(parameter);
    }



}
