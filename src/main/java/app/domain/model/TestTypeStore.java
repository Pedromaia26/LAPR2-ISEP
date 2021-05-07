package app.domain.model;

import java.util.List;

public class TestTypeStore {

    private List <TestType> testTypeList;

    public TestType createTestType (String description, String collectingMethod, String code, List<ParameterCategory> cat) {
        return new TestType(code, description, code, cat);
    }

    public boolean validateTestType (TestType tt){
        if (tt == null)
            return false;
        return !this.testTypeList.contains(tt);
    }

    public boolean saveTestType (TestType tt){
        if (!validateTestType(tt))
            return false;
        return testTypeList.add(tt);
    }
}
