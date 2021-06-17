package app.adapter;

import app.domain.model.ExternalModule;
import app.domain.model.Parameter;
import app.domain.model.ReferenceValue;
import com.example3.CovidReferenceValues1API;

public class ExternalModuleAdapter1 implements ExternalModule {


    private CovidReferenceValues1API covid = new CovidReferenceValues1API();


    @Override
    public ReferenceValue getReferenceValue(Parameter parameter) {

       Double min = covid.getMinReferenceValue(parameter.getCode(), 12345);
       Double max = covid.getMaxReferenceValue(parameter.getCode(), 12345);
       String metric = covid.usedMetric(parameter.getCode(), 12345);

        return new ReferenceValue(min, max, metric);
    }

    /*@Override
    public String getMetric(Parameter parameter) {
        return null;
    }*/
}
