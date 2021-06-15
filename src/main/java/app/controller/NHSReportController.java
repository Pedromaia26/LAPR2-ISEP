package app.controller;

import app.domain.model.Company;
import app.domain.model.TestStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class NHSReportController {

    private Company c;
    private TestStore tStore;

    public NHSReportController() throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        this(App.getInstance().getCompany());
        tStore = c.getTestStore();

    }

    public NHSReportController(Company c) throws OutputException, BarcodeException, ParseException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.c = c;
        tStore = c.getTestStore();
    }




   /* public void getTestsByInterval(Date begin, Date end){
        tStore.getTestsInInterval(begin, end);


    }*/

}
