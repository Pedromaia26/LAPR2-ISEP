package app.controller;

import app.domain.model.*;
import app.mappers.ParameterCategoryMapper;
import app.mappers.TestTypeMapper;
import app.mappers.dto.ParameterCategoryDto;
import app.mappers.dto.TestTypeDTO;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class TestTypeController {

    private Company company;
    private ParameterCategory pc;
    private TestTypeStore testTypeStore;
    private ParameterCategoryStore parameterCategoryStore;
    private TestType tt;
    private ParameterCategoryMapper parameterCategoryMapper;
    private TestTypeMapper ttMapper;

    public TestTypeController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
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

