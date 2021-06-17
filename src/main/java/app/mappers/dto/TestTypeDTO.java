package app.mappers.dto;

import app.domain.model.ParameterCategory;
import app.domain.model.TestType;

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

    /**
     * Returns the description of a test DTO.
     * @return the description of the test DTO.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the collecting method of a test DTO.
     * @return the collecting method of the test DTO.
     */

    public String getCollectingMethod() {
        return collectingMethod;
    }

    /**
     * Returns the code of a test DTO.
     * @return the code of the test DTO.
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the list of parameter categories belonging to a test DTO.
     * @return the list of parameter categories for a test DTO.
     */

    public List<ParameterCategory> getListPC() {
        return listPC;
    }

    /**
     * Returns the textual description of a test type Dto.
     * @return characteristics of the test type DTO.
     */
    @Override
    public String toString() {
        return "TestTypeDTO{" +
                "description='" + description + "'" +
        ", code='" + code + "'" +
        '}';
    }

    /**
     * Constructs an instance of TestTypeDTO with the same attributes as the received TestType object.
     *
     * @param tt The type of test to be copied
     */

    public TestTypeDTO(TestType tt){
        this.description = tt.getDescription();
        this.collectingMethod= tt.getCollectingMethod();
        this.code = tt.getCode();
        this.listPC = tt.getListPC();
    }
}