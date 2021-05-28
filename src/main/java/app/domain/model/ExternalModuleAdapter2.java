package app.domain.model;

import com.example2.ExternalModule2API;

public class ExternalModuleAdapter2 implements ExternalModule{


    ExternalModule2API blood = new ExternalModule2API();

    @Override
    public ReferenceValue getReferenceValue(Parameter parameter) {

        Double min = blood.getReferenceFor(parameter.getCode()).getMinValue();
        Double max = blood.getReferenceFor(parameter.getCode()).getMaxValue();


        return new ReferenceValue(min, max);

    }

    @Override
    public String getMetric (Parameter parameter){
        return blood.getMetricsFor(parameter.getCode());
    }
}
