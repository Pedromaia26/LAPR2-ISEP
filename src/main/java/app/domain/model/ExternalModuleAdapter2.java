package app.domain.model;

import com.example2.EMRefValue;
import com.example2.ExternalModule2API;
import com.example3.CovidReferenceValues1API;

public class ExternalModuleAdapter2 {

    public class ExternalModuleAdapter1 implements ExternalModule{
        ExternalModule2API blood;

        @Override
        public ReferenceValue getReferenceValue(Parameter parameter) {
            Double min = blood.getReferenceFor(parameter.getCode()).getMinValue();
            Double max = blood.getReferenceFor(parameter.getCode()).getMaxValue();
            String metric = blood.getMetricsFor(parameter.getCode());

            ReferenceValue ref = new ReferenceValue(min, max);

            return ref;
        }
    }
}
