package app.domain.model;

import com.example1.ExternalModule3API;

public class ExternalModuleAdapter3 {
    public class ExternalModuleAdapter1 implements ExternalModule{
        ExternalModule3API blood;

        @Override
        public ReferenceValue getReferenceValue(Parameter parameter) {
            Double min = blood.getMinReferenceValue(parameter.getCode(), 12345);
            Double max = blood.getMaxReferenceValue(parameter.getCode(), 12345);
            String metric = blood.usedMetric(parameter.getCode(), 12345);

            return new ReferenceValue(min, max);
        }
    }
}
