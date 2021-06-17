package app.mappers.dto;

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

    public Parameter getParameterdto() {
        return parameterdto;
    }

    public TestParameterResult getTprdto() {
        return tprdto;
    }

    @Override
    public String toString() {
        return "TestParameterDto{" +
                "parameterdto=" + parameterdto +
                ", tprdto=" + tprdto +
                '}';
    }
}
