package app.domain.model;

import com.example3.CovidReferenceValues1API;

public class ExternalModuleAdapter1 implements ExternalModule{
    CovidReferenceValues1API covid;

    @Override
    public ReferenceValue getReferenceValue(Parameter parameter) {
       Double min = covid.getMinReferenceValue(parameter.getCode(), 12345);
       Double max = covid.getMaxReferenceValue(parameter.getCode(), 12345);
       String metric = covid.usedMetric(parameter.getCode(), 12345);

        return new ReferenceValue(min, max);
    }
}
