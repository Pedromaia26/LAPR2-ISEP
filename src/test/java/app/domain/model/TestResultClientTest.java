package app.domain.model;

import app.mappers.dto.ParameterDTO;
import app.mappers.dto.TestParameterResultDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestResultClientTest {

    @Test
    public void getShortName() {

        ParameterCategory parameterCategory=new ParameterCategory("ola","11111");

        Parameter parameter = new Parameter("12345","asda","asdad",parameterCategory);

        ParameterDTO parameterDTO = new ParameterDTO(parameter);

        ReferenceValue referenceValue=new ReferenceValue(1.0,2.0,"test");


        TestParameterResult testParameterResult = new TestParameterResult(1.0,"test",referenceValue );

        TestParameterResultDTO testParameterResultDTO = new TestParameterResultDTO(testParameterResult);

        TestResultClient testResultClient = new TestResultClient(parameterDTO,testParameterResultDTO);

        assertEquals("asda",testResultClient.getShortName());

    }

    @Test
    public void getMinimum() {

        ParameterCategory parameterCategory=new ParameterCategory("ola","11111");

        Parameter parameter = new Parameter("12345","asda","asdad",parameterCategory);

        ParameterDTO parameterDTO = new ParameterDTO(parameter);

        ReferenceValue referenceValue=new ReferenceValue(1.0,2.0,"test");


        TestParameterResult testParameterResult = new TestParameterResult(1.0,"test",referenceValue );

        TestParameterResultDTO testParameterResultDTO = new TestParameterResultDTO(testParameterResult);

        TestResultClient testResultClient = new TestResultClient(parameterDTO,testParameterResultDTO);

        assertEquals((Double)1.0,testResultClient.getMinimum());

    }

    @Test
    public void getMaximum() {

        ParameterCategory parameterCategory=new ParameterCategory("ola","11111");

        Parameter parameter = new Parameter("12345","asda","asdad",parameterCategory);

        ParameterDTO parameterDTO = new ParameterDTO(parameter);

        ReferenceValue referenceValue=new ReferenceValue(1.0,2.0,"test");


        TestParameterResult testParameterResult = new TestParameterResult(1.0,"test",referenceValue );

        TestParameterResultDTO testParameterResultDTO = new TestParameterResultDTO(testParameterResult);

        TestResultClient testResultClient = new TestResultClient(parameterDTO,testParameterResultDTO);

        assertEquals((Double)2.0,testResultClient.getMaximum());
    }

    @Test
    public void getValue() {
        ParameterCategory parameterCategory=new ParameterCategory("ola","11111");

        Parameter parameter = new Parameter("12345","asda","asdad",parameterCategory);

        ParameterDTO parameterDTO = new ParameterDTO(parameter);

        ReferenceValue referenceValue=new ReferenceValue(1.0,2.0,"test");


        TestParameterResult testParameterResult = new TestParameterResult(1.0,"test",referenceValue );

        TestParameterResultDTO testParameterResultDTO = new TestParameterResultDTO(testParameterResult);

        TestResultClient testResultClient = new TestResultClient(parameterDTO,testParameterResultDTO);

        assertEquals((Double)1.0,testResultClient.getValue());
    }

    @Test
    public void getCode() {
        ParameterCategory parameterCategory=new ParameterCategory("ola","11111");

        Parameter parameter = new Parameter("12345","asda","asdad",parameterCategory);

        ParameterDTO parameterDTO = new ParameterDTO(parameter);

        ReferenceValue referenceValue=new ReferenceValue(1.0,2.0,"test");


        TestParameterResult testParameterResult = new TestParameterResult(1.0,"test",referenceValue );

        TestParameterResultDTO testParameterResultDTO = new TestParameterResultDTO(testParameterResult);

        TestResultClient testResultClient = new TestResultClient(parameterDTO,testParameterResultDTO);

        assertEquals("12345",testResultClient.getCode());
    }

    @Test
    public void testToString() {
        ParameterCategory parameterCategory=new ParameterCategory("ola","11111");

        Parameter parameter = new Parameter("12345","asda","asdad",parameterCategory);

        ParameterDTO parameterDTO = new ParameterDTO(parameter);

        ReferenceValue referenceValue=new ReferenceValue(1.0,2.0,"test");


        TestParameterResult testParameterResult = new TestParameterResult(1.0,"test",referenceValue );

        TestParameterResultDTO testParameterResultDTO = new TestParameterResultDTO(testParameterResult);

        TestResultClient testResultClient = new TestResultClient(parameterDTO,testParameterResultDTO);


        assertEquals("TestResultClient{shortName='asda', minimum=1.0, maximum=2.0, code='12345', value=1.0, metric='test'}",testResultClient.toString());
    }

    @Test
    public void getMetric() {
        ParameterCategory parameterCategory=new ParameterCategory("ola","11111");

        Parameter parameter = new Parameter("12345","asda","asdad",parameterCategory);

        ParameterDTO parameterDTO = new ParameterDTO(parameter);

        ReferenceValue referenceValue=new ReferenceValue(1.0,2.0,"test");


        TestParameterResult testParameterResult = new TestParameterResult(1.0,"test",referenceValue );

        TestParameterResultDTO testParameterResultDTO = new TestParameterResultDTO(testParameterResult);

        TestResultClient testResultClient = new TestResultClient(parameterDTO,testParameterResultDTO);

        assertEquals("test",testResultClient.getMetric());
    }
}