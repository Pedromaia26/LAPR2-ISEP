package app.domain.model;

import app.controller.App;

import java.util.ArrayList;
import java.util.List;

public class SampleMapper {
    public static Sample toModel(SampleDTO dto) {

        String orderid = dto.getOrderid();
        String dataColl = dto.getDataColl();
        String timeColl = dto.getTimeColl();

        LabOrder test= App.getInstance().getCompany().getLabOrderStore().getLabOrderByCode(orderid);

        List<ParameterCategory> listPC = new ArrayList<>();


        TestType testesss = new TestType("asd","asd","12345",listPC) ;//orderid.getTestTypebycode.....



        return new Sample(test);


    }
}
