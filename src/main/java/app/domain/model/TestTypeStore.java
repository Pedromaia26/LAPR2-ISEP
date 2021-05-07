package app.domain.model;

import java.util.List;

public class TestTypeStore {

    private List<TestType> testTypeList;

    public TestType createTestType (String code, String description, String nhsId) {
        return new TestType(code, description, nhsId);
    }

    public boolean validateTestType (TestType tt){
        if (tt == null)
            return false;
        return !this.testTypeList.contains(tt);
    }

    public void addTestType (TestType tt){
        if (validateTestType(tt))
            testTypeList.add(tt);
    }

    public boolean saveTestType (TestType tt){
        if (!validateTestType(tt))
            return false;
        return testTypeList.add(tt);
    }
}
