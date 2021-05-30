package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.util.ArrayList;
import java.util.List;

public class SampleMapper {
    /**
     * Recieves the sampleDTO and returns the new Sample.
     * @param dto The sampleDTO
     * @return new sample.
     */
     public Test toModel(SampleDTO dto, TestStore store) {

          String code=dto.getOrderid();


          return store.getTestByCode(code);
    }
}
