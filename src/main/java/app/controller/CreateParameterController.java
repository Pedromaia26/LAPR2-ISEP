package app.controller;


import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.mappers.dto.ParameterCategoryDto;
import app.mappers.ParameterCategoryMapper;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class CreateParameterController {

    private Company company;
    private List<ParameterCategoryDto> pcDtoList ;
    private Parameter parameter;
    private ParameterCategory cat;
    private ParameterCategoryMapper parameterCategoryMapper;

    public CreateParameterController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
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
        try {
            this.cat = this.company.getParameterCategoryStore().getParameterCategoryByCode(categoryCode);
            this.parameter = this.company.getParameterStore().createParameter(code, shortName, description, cat);
            return this.company.getParameterStore().validateParameter(parameter);
        }catch(IllegalArgumentException e){
            System.out.println("Invalid data! These are the rules:\nCode: 5 alphanumeric characters\nShort Name: no more than 8 characters\nDescription: no more than 20 characters\n");
            return false;
        }
    }

    public boolean saveParameter(){
        return this.company.getParameterStore().saveParameter(parameter);
    }

    public List<ParameterCategory> getParameterCategory(){
        return this.company.getParameterCategoryStore().getParameterCategories();
    }

    public List<ParameterCategoryDto> getParameterCategoryDto(){
        try {
            return this.parameterCategoryMapper.toDto(getParameterCategory());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("There are no parameter categories!\nPlease create one first.");
            return new ArrayList<ParameterCategoryDto>();
        }
    }

}
