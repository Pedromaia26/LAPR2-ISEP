package app.domain.model;

import java.io.Serializable;
import java.util.Objects;

public class BarcodeCreate implements Serializable {
    /**
     * Object that contains the barcode
     */
    private Object barcode;
    /**
     * String that contains the barcode number
     */
    private String barcodeNumber;
    /**
     * Create a barcode, receiving by parameter the barcode Number and the barcode.
     * @param barcode The barcode
     * @param barcodeNumber The barcode Number
     */
    public BarcodeCreate(Object barcode, String barcodeNumber) {
        this.barcode = barcode;
        this.barcodeNumber = barcodeNumber;
    }
    /**
     * Returns the barcode of a barcodecreator.
     * @return the barcode of a barcodecreator.
     */
    public Object getBarcode() {
        return barcode;
    }
    /**
     * Returns the barcode number of a barcodecreator.
     * @return the barcode number of a barcodecreator.
     */
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
    /**
     * Returns the textual description of a barcode creator.
     * @return characteristics of a barcode creator.
     */
    @Override
    public String toString() {
        return "BarcodeCreate{" +
                "barcode=" + barcode +
                ", barcodeNumber='" + barcodeNumber + '\'' +
                '}';
    }
}
