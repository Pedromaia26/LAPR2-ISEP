package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.stores.ParameterCategoryStore;

public class CreateParameterCategoryController {

    private Company company;
    private ParameterCategory pc;
    private ParameterCategoryStore pcStore;

    public CreateParameterCategoryController() {
        this(App.getInstance().getCompany());
    }
    public CreateParameterCategoryController(Company company) {
        this.company = company;
        this.pc = null;
    }

    public boolean createParameterCategory(String name, String code) {
        this.pc = this.company.getParameterCategoryStore().createParameterCategory(name, code);
        //return this.company.getParameterCategoryStore().validateParameterCategory(pc);
        return true;
    }
    public boolean saveParameterCategory() {
        return this.company.getParameterCategoryStore().saveParameterCategory(pc);
    }

}
