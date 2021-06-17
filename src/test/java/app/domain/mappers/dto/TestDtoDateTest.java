package app.domain.mappers.dto;

import app.mappers.dto.TestDtoDate;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDtoDateTest {

    @Test
    public void testToString() {
        Date registrationDate = new Date();
        Date analysisDate = new Date();
        Date diagnosisDate = new Date();

        TestDtoDate test = new TestDtoDate("000000000001",registrationDate, analysisDate, diagnosisDate);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String expect = String.format("Code: 000000000001 %nRegistration Date: %s %nAnalysisDate: %s %nDiagnosis Date: %s", formatter.format(registrationDate), formatter.format(analysisDate), formatter.format(diagnosisDate));
        String actual = test.toString();

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testToStringNotEquals() {
        Date registrationDate = new Date();
        Date analysisDate = new Date();
        Date diagnosisDate = new Date();

        TestDtoDate test = new TestDtoDate("000000000001",registrationDate, analysisDate, diagnosisDate);
        String expect = String.format("Code: 000000000001 Registration Date: %s AnalysisDate: %s Diagnosis Date: %s", registrationDate, analysisDate, diagnosisDate);
        String actual = test.toString();

        Assert.assertNotEquals(expect, actual);
    }
}