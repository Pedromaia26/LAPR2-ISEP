package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.util.ArrayList;
import java.util.List;

public class SampleMapper {

    /**
     * Recieves the SampleDTO and returns the new Sample.
     * @param dto The SampleDTO
     * @return new Sample.
     */
    public static Sample toModel(SampleDTO dto) throws OutputException, BarcodeException {

        String orderid = dto.getOrderid();


        LabOrder test= App.getInstance().getCompany().getLabOrderStore().getLabOrderByCode(orderid);

        List<ParameterCategory> listPC = new ArrayList<>();




        return new Sample(test);


    }
}
