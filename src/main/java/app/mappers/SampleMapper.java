package app.mappers;

import app.mappers.dto.SampleDTO;
import app.domain.model.Test;
import app.domain.model.TestStore;

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
