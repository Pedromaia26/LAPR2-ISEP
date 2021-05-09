package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryStore {

    /**
     * List that contains the parameters categories.
     */
    private List<ParameterCategory> cat;

    public ParameterCategoryStore(){
        cat = new ArrayList<>();
    }


    public void addToList (ParameterCategory category){
            cat.add(category);
    }

    public ParameterCategory createParameterCategory(String name, String code) {
        return new ParameterCategory(name, code);

    }
    public boolean validateParameterCategory(ParameterCategory pc) {
        if (pc == null)
            return false;
        return (!this.cat.contains(pc));
    }

    public boolean saveParameterCategory(ParameterCategory pc) {
        if(cat == null) {
            cat = new ArrayList<>();
        }

        if (validateParameterCategory(pc)) {
            cat.add(pc);
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


}
