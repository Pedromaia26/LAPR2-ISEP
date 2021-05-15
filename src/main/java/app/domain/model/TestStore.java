package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class TestStore {
    private List<Test> tests= new ArrayList<>();

    public List<Test> getTests() {
        return tests;
    }

    public void addToList (Test test){
        tests.add(test);
    }




}
