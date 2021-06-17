package app.adapter;

import app.domain.model.ExternalModule;
import app.domain.model.Parameter;
import app.domain.model.ReferenceValue;
import com.example1.ExternalModule3API;

public class ExternalModuleAdapter3 implements ExternalModule {

    private ExternalModule3API blood = new ExternalModule3API();

    @Override
    public ReferenceValue getReferenceValue(Parameter parameter) {
        Double min = blood.getMinReferenceValue(parameter.getCode(), 12345);
        Double max = blood.getMaxReferenceValue(parameter.getCode(), 12345);
        String metric = blood.usedMetric(parameter.getCode(), 12345);

        return new ReferenceValue(min, max, metric);
    }

    /*@Override
    public String getMetric(Parameter parameter) {
        return null;
    }*/
}
