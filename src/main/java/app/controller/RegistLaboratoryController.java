package app.controller;

import app.domain.model.*;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RegistLaboratoryController {
    private Company company;
    private TestType tt;
    private TestTypeStore testTypeStore;
    private LaboratoryStore LaboratoryStore;
    private Laboratory cl;


    public RegistLaboratoryController() throws IllegalAccessException, ClassNotFoundException, InstantiationException, IOException, OutputException, ParseException, BarcodeException {
        this(App.getInstance().getCompany());
    }

    public RegistLaboratoryController(Company company) {
        this.company = company;
    }

    public boolean createLaboratory(String laboratoryID, String name, String address, long phoneNumber, long tinNumber, List <TestType> testTypes) {
        List <TestType> tt = new ArrayList<>();
        for (TestType tts: testTypes){
            tt.add(this.company.getTestTypeStore().getTestTypeByCode(tts.getCode()));
        }
        this.cl = this.company.getLaboratoryStore().createLaboratory(laboratoryID, name, address, phoneNumber, tinNumber, testTypes);
        return this.company.getLaboratoryStore().validateLaboratory(cl);
    }

    public TestTypeStore getTestTypeStore() {
        return this.company.getTestTypeStore();
    }

    public boolean saveLaboratory () {
        return this.company.getLaboratoryStore().saveLaboratory(cl);
    }
}
