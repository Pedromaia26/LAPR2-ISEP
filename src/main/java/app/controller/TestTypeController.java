package app.controller;

import app.domain.model.*;

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

    public boolean createTestType(String description, String collectingMethod, String code, List<ParameterCategory> cat) {
        this.pc = this.company.getParameterCategoryStore().getParameterCategoryByCode(code);
        return this.company.getTestTypeStore().validateTestType(tt);
    }

        public ParameterCategoryStore getParameterCategoryStore() {
            return parameterCategoryStore;
        }

        public boolean saveTestType () {
            return this.company.getTestTypeStore().saveTestType(tt);
        }
}

