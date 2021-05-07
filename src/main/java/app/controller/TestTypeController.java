package app.controller;

import app.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class TestTypeController {
    private Company company;
    private ParameterCategory pc;
    private TestTypeStore testTypeStore;
    private ParameterCategoryStore parameterCategoryStore;
    private TestType tt;


    public TestTypeController() {
        this(App.getInstance().getCompany());
    }

    public TestTypeController(Company company) {

    }

    public boolean createTestType(String description, String collectingMethod, String code, List <ParameterCategory> categories) {
        List <ParameterCategory> cat = new ArrayList<>();
        for (ParameterCategory cats: categories){
            cat.add(this.company.getParameterCategoryStore().getParameterCategoryByCode(cats.getCode()));
        }
        this.tt = this.company.getTestTypeStore().createTestType(description, collectingMethod, code, cat);
        return this.company.getTestTypeStore().validateTestType(tt);
    }

        public ParameterCategoryStore getParameterCategoryStore() {
            return this.company.getParameterCategoryStore();
        }

        public boolean saveTestType () {
            return this.company.getTestTypeStore().saveTestType(tt);
        }
}

