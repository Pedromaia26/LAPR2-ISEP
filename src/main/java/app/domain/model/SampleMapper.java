package app.domain.model;

import app.controller.App;

import java.util.ArrayList;
import java.util.List;

public class SampleMapper {

    /**
     * Recieves the SampleDTO and returns the new Sample.
     * @param dto The SampleDTO
     * @return new Sample.
     */
    public static Sample toModel(SampleDTO dto) {

        String orderid = dto.getOrderid();


        LabOrder test= App.getInstance().getCompany().getLabOrderStore().getLabOrderByCode(orderid);

        List<ParameterCategory> listPC = new ArrayList<>();




        return new Sample(test);


    }
}
