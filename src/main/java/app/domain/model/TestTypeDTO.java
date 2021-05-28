package app.domain.model;

import java.util.List;

public class TestTypeDTO {
    private String description;

    /**
    String that contains the description of a collecting method
     */
    private String collectingMethod;

    /**
     * String that contains the code of a type of test
     */
    private String code;

    /**
     * List that contains the parameter categories.
     */
    private List<ParameterCategory> listPC;

    @Override
    public String toString() {
        return "TestTypeDTO{" +
                "description='" + description + "'" +
        ", code='" + code + "'" +
        '}';
    }

    public TestTypeDTO(TestType tt){
        this.description = tt.getDescription();
        this.collectingMethod= tt.getCollectingMethod();
        this.code = tt.getCode();
        this.listPC = tt.getListPC();
    }
}