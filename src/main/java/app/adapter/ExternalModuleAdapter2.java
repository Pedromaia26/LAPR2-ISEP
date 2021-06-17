package app.adapter;

import app.domain.model.ExternalModule;
import app.domain.model.Parameter;
import app.domain.model.ReferenceValue;
import com.example2.ExternalModule2API;

public class ExternalModuleAdapter2 implements ExternalModule {


    private ExternalModule2API blood = new ExternalModule2API();

    @Override
    public ReferenceValue getReferenceValue(Parameter parameter) {

        Double min = blood.getReferenceFor(parameter.getCode()).getMinValue();
        Double max = blood.getReferenceFor(parameter.getCode()).getMaxValue();
        String metric = blood.getMetricsFor(parameter.getCode());

        return new ReferenceValue(min, max, metric);

    }

    /*@Override
    public String getMetric (Parameter parameter){
        return blood.getMetricsFor(parameter.getCode());
    } */
}
