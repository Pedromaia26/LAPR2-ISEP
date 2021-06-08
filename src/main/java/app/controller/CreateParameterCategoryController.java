package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.ParameterCategoryStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;

import java.io.IOException;

public class CreateParameterCategoryController {

    private Company company;
    private ParameterCategory pc;
    private ParameterCategoryStore pcStore;

    public CreateParameterCategoryController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this(App.getInstance().getCompany());
    }
    public CreateParameterCategoryController(Company company) {
        this.company = company;
        this.pc = null;
    }

    public boolean createParameterCategory(String name, String code) {
        try {
            this.pc = this.company.getParameterCategoryStore().createParameterCategory(name, code);
            //return this.company.getParameterCategoryStore().validateParameterCategory(pc);
            return true;
        }catch(IllegalArgumentException e){
            System.out.println("Invalid data! These are the rules:\nName: no more than 10 characters\nCode: 5 alphanumeric characters\n");
            return false;
        }
    }
    public boolean saveParameterCategory() {
        return this.company.getParameterCategoryStore().saveParameterCategory(pc);
    }

}
