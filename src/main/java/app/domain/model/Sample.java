package app.domain.model;

import java.util.Objects;

public class Sample extends Test{

    private String barcode;

    public Sample(LabOrder labOrder) {
        super(labOrder);
        this.barcode="asd";


        //Criar barcode automatico e fazer verificacao se nao existe igual
    }


    @Override
    public String toString() {
        return "Sample:" +
                "barcode='" + barcode + '\'';
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
