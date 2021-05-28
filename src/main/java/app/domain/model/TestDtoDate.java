package app.domain.model;

import java.security.Timestamp;
import java.util.Date;

public class TestDtoDate {

    /**
     * String that contains the code of a given test.
     */
    private String code;

    /**
     * Date that contains the date of registration of a given test.
     */
    private Date registrationDate;

    /**
     * Date that contains the date of analysis of a given test.
     */
    private Date analysisDate;

    /**
     * Date that contains the date of diagnosis of a given test.
     */
    private Date diagnosisDate;

    /**
     * Constructs an instance of TestDtoDate with the attributes received.
     *
     * @param code The code of the test.
     * @param analysisDate The date of analysis of the test.
     * @param diagnosisDate The date of diagnosis of the test.
     */
    public TestDtoDate(String code,Date registrationDate, Date analysisDate, Date diagnosisDate){
        this.code = code;
        this.registrationDate = registrationDate;
        this.analysisDate = analysisDate;
        this.diagnosisDate = diagnosisDate;
    }

    /**
     * Returns the textual description of dates of a test.
     * @return characteristics of a test.
     */
    @Override
    public String toString() {
        return String.format("Code: %s\nAnalysisDate: %s\nDiagnosis Date: %s", code, analysisDate, diagnosisDate);
    }
}
