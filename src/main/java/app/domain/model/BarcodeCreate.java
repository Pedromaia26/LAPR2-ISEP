package app.domain.model;

import java.util.Objects;

public class BarcodeCreate {
    private Object barcode;
    private String barcodeNumber;

    public BarcodeCreate(Object barcode, String barcodeNumber) {
        this.barcode = barcode;
        this.barcodeNumber = barcodeNumber;
    }

    public Object getBarcode() {
        return barcode;
    }

    public String getBarcodeNumber() {
        return barcodeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarcodeCreate sample = (BarcodeCreate) o;
        return Objects.equals(barcode, sample.barcode) && Objects.equals(barcodeNumber, sample.barcodeNumber);
    }

    @Override
    public String toString() {
        return "BarcodeCreate{" +
                "barcode=" + barcode +
                ", barcodeNumber='" + barcodeNumber + '\'' +
                '}';
    }
}
