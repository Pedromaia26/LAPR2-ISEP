package app.domain.model;

// import com.example2.EMRefValue;

import java.lang.ref.Reference;

public interface ExternalModule {
    ReferenceValue getReferenceValue (Parameter parameter);
    // String getMetric (Parameter parameter);
}
