package app.mappers.dto;


import java.text.SimpleDateFormat;
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
        this.registrationDate = new Date(registrationDate.getTime());
        this.analysisDate = new Date(analysisDate.getTime());
        this.diagnosisDate = new Date(diagnosisDate.getTime());
    }

    /**
     * Returns the textual description of dates of a test.
     * @return characteristics of a test.
     */
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return String.format("Code: %s %nRegistration Date: %s %nAnalysisDate: %s %nDiagnosis Date: %s", code, formatter.format(registrationDate), formatter.format(analysisDate), formatter.format(diagnosisDate));
    }
}
