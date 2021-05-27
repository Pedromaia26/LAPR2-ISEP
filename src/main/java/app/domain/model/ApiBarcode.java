package app.domain.model;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

public interface ApiBarcode {

    BarcodeCreate makeUPCABarcode(String barcodeText) throws BarcodeException, OutputException;
}
