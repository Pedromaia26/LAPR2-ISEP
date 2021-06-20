package app.domain.model;

import app.serialization.Serialization;

import java.util.ArrayList;
import java.util.List;

public class ParameterStore {

    /**
     * List that contains the parameters.
     */
    private List<Parameter> parameterList;

    /**
     * Object used to save the information.
     */
    private Serialization ser = new Serialization();

    public ParameterStore(){
        parameterList = new ArrayList<>();
    }


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
        if (!validateParameter(parameter)) {
            return false;
        }
        this.parameterList.add(parameter);
        save();
        return true;
    }

    public void addParameter(Parameter parameter) {
        parameterList.add(parameter);
    }

    /**
     * Returns the list of a parameters
     * @return the list of a parameters
     */

    public List<Parameter> getParameterList (){
        return parameterList;
    }
    /**
     * Searches for the parameter with a specific code.
     * @return the the parameter with a specific code.
     */
    public Parameter getParameterByCode(String code) {
        for (Parameter tt: this.parameterList) {
            if (code.equals(tt.getCode()))
                return tt;
        }
        throw new IllegalArgumentException("There is no Parameter with such code!");
    }

    public void save(){
        ser.escrever((List<Object>) (List<?>) parameterList, "parameter.ser");
    }

    public void read(Company c){
        parameterList = (List<Parameter>) (List<?>) ser.ler("parameter.ser");
    }
}
