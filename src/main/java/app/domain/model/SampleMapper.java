package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.util.ArrayList;
import java.util.List;

public class SampleMapper {

     public Test toModel(SampleDTO dto, TestStore store) throws OutputException, BarcodeException {

          String code=dto.getOrderid();


          return store.getTestByCode(code);
    }
}
