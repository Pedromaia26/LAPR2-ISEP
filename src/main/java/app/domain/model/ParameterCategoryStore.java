package app.domain.model;

import java.util.List;

public class ParameterCategoryStore {

    private List<ParameterCategory> cat;

    public ParameterCategory getParameterCategoryByCode(String code) {
        for (ParameterCategory category : cat) {
            if (code.equals(category.getCode()))
                return category;
        }
        throw new IllegalArgumentException("There is no Parameter Category with such code!");
    }

    public List<ParameterCategory> getParameterCategories(){
        return cat;
    }
}
