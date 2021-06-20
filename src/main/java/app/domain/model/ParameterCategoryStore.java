package app.domain.model;

import app.serialization.Serialization;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryStore {

    /**
     * List that contains the parameters categories.
     */
    private List<ParameterCategory> cat;
    private List<ParameterCategory> pc;

    /**
     * Object used to save the information.
     */
    private Serialization ser = new Serialization();



    public ParameterCategoryStore(){
        cat = new ArrayList<>();
        pc = new ArrayList<>();
    }


    public void addToList (ParameterCategory category){
            cat.add(category);
    }

    public ParameterCategory createParameterCategory(String name, String code) {
        return new ParameterCategory(name, code);

    }
    /**
     * Validates the ParameterCategory received.
     * @param pc the parameterCategory to be validated.
     * @return True if the parameterCategory is successfully validated, false if it is not.
     */
    public boolean validateParameterCategory(ParameterCategory pc) {
        if (pc == null)
            return false;
        return (!this.cat.contains(pc));
    }
    /**
     * Saves the parameter category received.
     * @param pc the parameterCategory to be saved.
     * @return True if the parameterCategory is successfully saved, false if it is not.
     */
    public boolean saveParameterCategory(ParameterCategory pc) {
        if(cat == null) {
            cat = new ArrayList<>();
        }

        if (validateParameterCategory(pc)) {
            cat.add(pc);
            save();
            return true;
        } else {
            return false;
        }


    }


    /**
     * Returns the parameter category corresponding to the received code.
     *
     * @param code The code of the intended parameter category
     * @return The intended parameter category
     */
    public ParameterCategory getParameterCategoryByCode(String code) {
        for (ParameterCategory category : cat) {
            if (code.equals(category.getCode()))
                return category;
        }
        throw new IllegalArgumentException("There is no Parameter Category with such code!");
    }

    /**
     * Returns the list of parameter categories.
     *
     * @return The list of parameter categories
     */
    public List<ParameterCategory> getParameterCategories(){
        return cat;
    }

    public List<ParameterCategory> getParameterCategoryByCode(List<String> categories) {
        for (String cats: categories){
            pc.add(getParameterCategoryByCode(cats));
        }
            if (pc.isEmpty())
            throw new IllegalArgumentException("There is no Parameter Category with such code!");
            return pc;
    }


    public void save(){
        ser.escrever((List<Object>) (List<?>) cat, "parameterCategory.ser");
    }

    public void read(Company c){
        cat = (List<ParameterCategory>) (List<?>) ser.ler("parameterCategory.ser");
    }
    /**
     * Searches for the parameter category with a specific name.
     * @return the the parameter category with a specific name.
     */
    public ParameterCategory getParameterCategoryByDescription(String test) {
        for (ParameterCategory category : cat) {
            if (test.equals(category.getName()))
                return category;
        }
        throw new IllegalArgumentException("There is no Parameter Category with such name!");
    }
}
