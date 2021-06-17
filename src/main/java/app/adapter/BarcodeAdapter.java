package app.adapter;

import app.domain.model.ApiBarcode;
import app.domain.model.BarcodeCreate;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

public class BarcodeAdapter implements ApiBarcode {


    @Override
    public BarcodeCreate makeUPCABarcode(String barcodeText) throws BarcodeException, OutputException {
        Barcode barcodes = BarcodeFactory.createUPCA(barcodeText);
        barcodes.setPreferredBarHeight(150);
        BarcodeImageHandler.getImage(barcodes);

        return new BarcodeCreate(barcodes,barcodeText) ;
    }


}
