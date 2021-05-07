package app.controller;

import app.domain.model.*;

import java.util.List;

public class TestTypeController {
    private Company company;
    private ParameterCategory pc;
    private TestTypeStore testTypeStore;
    private ParameterCategoryStore parameterCategoryStore;
    private TestType tt;
    private List <ParameterCategory> cat;


    public TestTypeController() {
        this(App.getInstance().getCompany());
    }

    public TestTypeController(Company company) {

    }

    public boolean createTestType(String description, String collectingMethod, String code, String categoryCode) {
        this.pc = this.company.getParameterCategoryStore().getParameterCategoryByCode(categoryCode);
        cat.add(pc);
        this.tt = this.company.getTestTypeStore().createTestType(description, collectingMethod, code, cat);
        return this.company.getTestTypeStore().validateTestType(tt);
    }

        public ParameterCategoryStore getParameterCategoryStore() {
            return parameterCategoryStore;
        }

        public boolean saveTestType () {
            return this.company.getTestTypeStore().saveTestType(tt);
        }
}

