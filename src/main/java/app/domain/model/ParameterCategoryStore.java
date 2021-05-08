package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ParameterCategoryStore {

    /**
     * List that contains the parameters categories.
     */
    private List<ParameterCategory> cat = new ArrayList<>();


    public void addToList (ParameterCategory category){
        if (!cat.contains(category))
            cat.add(category);
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
