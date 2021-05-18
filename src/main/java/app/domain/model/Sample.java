package app.domain.model;

import app.controller.App;

import java.util.List;
import java.util.Objects;

public class Sample extends Test{
    /**
     * int that contains the barcode number of a sample
     */
    private int barcode;


    /**
     * Creates a sample, receiving by parameter the lab order of a test.
     * Checks all parameters rules to see if the inputted data is valid.
     *
     * @param labOrder The lab order
     */
    public Sample(LabOrder labOrder) {
        super(labOrder);

        this.barcode=createBarcode();
        //Criar barcode automatico e fazer verificacao se nao existe igual
    }

    /**
     * Counts all the samples already on the system +1 (starts on 1) to generate the sequential barcode number
     */
    public int createBarcode(){

        List<Test> tests=App.getInstance().getCompany().getTestStore().getTests();
        int c=1;
        for(Test testss : tests){
            for (Sample samples : testss.getSample()) {
                c++;
                }
            }

        return c;
    }
    /**
     * Returns the textual description of a sample.
     * @return characteristics of a sample.
     */
    @Override
    public String toString() {
        return "barcode number='" + barcode + '\'';
    }

    /**
     * Returns the barcode number of a sample.
     * @return the barcode number of a sample.
     */
    public int getBarcode() {
        return barcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sample sample = (Sample) o;
        return Objects.equals(barcode, sample.barcode);
    }
}
