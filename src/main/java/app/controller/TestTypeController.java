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
    private ParameterCategoryMapper parameterCategoryMapper;



    public TestTypeController() {
        this(App.getInstance().getCompany());
        this.parameterCategoryMapper = new ParameterCategoryMapper();
    }

    public TestTypeController(Company company) {
        this.company = company;
        this.parameterCategoryMapper = new ParameterCategoryMapper();
    }

    public boolean createTestType(String description, String collectingMethod, String code, List <String> categories) {
        List <ParameterCategory> cat;

        cat = (this.company.getParameterCategoryStore().getParameterCategoryByCode(categories));

        this.tt = this.company.getTestTypeStore().createTestType(description, collectingMethod, code, cat);
        return this.company.getTestTypeStore().validateTestType(tt);
    }

        public ParameterCategoryStore getParameterCategoryStore() {
            return this.company.getParameterCategoryStore();
        }

        public boolean saveTestType () {
            return this.company.getTestTypeStore().saveTestType(tt);
        }

    public List<ParameterCategory> getParameterCategory(){
        return this.company.getParameterCategoryStore().getParameterCategories();
    }

    public List<ParameterCategoryDto> getParameterCategoryDto(){
        return this.parameterCategoryMapper.toDto(getParameterCategory());
    }


    // public List<String> getParameterCategory2(){
        // return this.company.getParameterCategoryStore().getParameterCategoryByCode();
    // }
}

