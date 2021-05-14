package app.domain.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SampleStore {

    private List<Sample> sampleList = new ArrayList<>();


    public Sample RecordNewSample(SampleDTO dto) {
        return SampleMapper.toModel(dto);

    }

    public boolean validateSample(Sample nc){
        if (nc == null)
            return false;
        return ! this.sampleList.contains(nc);
    }

    public boolean addNewSample(Sample nc){
        if (!validateSample(nc))
            return false;
        return this.sampleList.add(nc);
    }


    public boolean saveSample(Sample nc) {
        validateSample(nc);

        return addNewSample(nc);
    }


}
