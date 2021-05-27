package app.domain.model;

public class BarcodeCreate {
    private Object ola;
    private String barcodeNumber;

    public BarcodeCreate(Object ola, String barcodeNumber) {
        this.ola = ola;
        this.barcodeNumber = barcodeNumber;
    }

    public Object getOla() {
        return ola;
    }

    public String getBarcodeNumber() {
        return barcodeNumber;
    }
}
