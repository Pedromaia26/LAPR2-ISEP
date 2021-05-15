package app.domain.model;

public class Sample extends Test{

    private String barcode;

    public Sample(LabOrder labOrder) {
        super(labOrder);
        this.barcode="asd";
    }

    @Override
    public String toString() {
        return "Sample{" +
                "barcode='" + barcode + '\'' +
                '}';
    }

}
