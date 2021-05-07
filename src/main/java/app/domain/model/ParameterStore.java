package app.domain.model;

import java.util.List;

public class ParameterStore {

    private List<Parameter> parameterList;

    public Parameter createParameter(String code, String shortName, String description, ParameterCategory category){
        return new Parameter(code, shortName, description, category);
    }

    public boolean validateParameter(Parameter parameter){
        if (parameter == null){
            return false;
        }
        return ! this.parameterList.contains(parameter);
    }

    public boolean saveParameter(Parameter parameter) {
        if (!validateParameter(parameter))
            return false;
        return this.parameterList.add(parameter);
    }


}
