package app.controller;

import app.domain.model.*;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
<<<<<<< HEAD
import java.text.ParseException;
=======
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
import java.util.ArrayList;
import java.util.List;

public class TestTypeController {

    private Company company;
    private ParameterCategory pc;
    private TestTypeStore testTypeStore;
    private ParameterCategoryStore parameterCategoryStore;
    private TestType tt;
    private ParameterCategoryMapper parameterCategoryMapper;
    private TestTypeMapper ttMapper;



<<<<<<< HEAD
    public TestTypeController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
=======
    public TestTypeController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException {
>>>>>>> 0b16295dad191dc0501148fa23580a90a24b6c66
        this(App.getInstance().getCompany());
        this.parameterCategoryMapper = new ParameterCategoryMapper();
        this.ttMapper = new TestTypeMapper();
    }

    public TestTypeController(Company company) {
        this.company = company;
        this.parameterCategoryMapper = new ParameterCategoryMapper();
        this.ttMapper = new TestTypeMapper();
    }

    public boolean createTestType(String description, String collectingMethod, String code, List <String> categories, String api) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        List <ParameterCategory> cat;

        cat = (this.company.getParameterCategoryStore().getParameterCategoryByCode(categories));

        this.tt = this.company.getTestTypeStore().createTestType(description, collectingMethod, code, cat, api);
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

    public List<TestType> getTestType(){
        return this.company.getTestTypeStore().getTestTypes();
    }

    public List<TestTypeDTO> getTestTypeDto(){
        return this.ttMapper.toDto(getTestType());
    }

    // public List<String> getParameterCategory2(){
        // return this.company.getParameterCategoryStore().getParameterCategoryByCode();
    // }
}

