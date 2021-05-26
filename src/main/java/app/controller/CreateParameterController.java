package app.controller;


import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.dto.ParameterCategoryDto;
import app.domain.model.mappers.ParameterCategoryMapper;

import java.util.ArrayList;
import java.util.List;


public class CreateParameterController {

    private Company company;
    private List<ParameterCategoryDto> pcDtoList ;
    private Parameter parameter;
    private ParameterCategory cat;
    private ParameterCategoryMapper parameterCategoryMapper;


    public CreateParameterController(){
        this(App.getInstance().getCompany());
        this.pcDtoList = new ArrayList<>();
        this.parameterCategoryMapper = new ParameterCategoryMapper();
    }

    public CreateParameterController(Company company){
        this.pcDtoList = new ArrayList<>();
        this.parameterCategoryMapper = new ParameterCategoryMapper();
        this.company = company;
    }

    public boolean createParameter(String code, String shortName, String description, String categoryCode){
        this.cat = this.company.getParameterCategoryStore().getParameterCategoryByCode(categoryCode);
        System.out.println("asdasd = " + cat);
        this.parameter = this.company.getParameterStore().createParameter(code, shortName, description, cat);
        return this.company.getParameterStore().validateParameter(parameter);
    }

    public boolean saveParameter(){
        return this.company.getParameterStore().saveParameter(parameter);
    }

    public List<ParameterCategory> getParameterCategory(){
        return this.company.getParameterCategoryStore().getParameterCategories();
    }

    public List<ParameterCategoryDto> getParameterCategoryDto(){
        return this.parameterCategoryMapper.toDto(getParameterCategory());
    }

}
