package app.domain.model;

import app.domain.model.Parameter;
import app.domain.model.TestParameter;
import app.domain.model.TestParameterResult;

public class TestParameterDto {

    /**
     *
     */
    private Parameter parameterdto;
    private TestParameterResult tprdto;

    public TestParameterDto(TestParameter testParameter) {
        parameterdto = testParameter.getParameter();
        tprdto = testParameter.getTpr();
    }
}
