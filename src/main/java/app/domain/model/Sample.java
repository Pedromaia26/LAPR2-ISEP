package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public class Sample extends Test{
    /**
     * int that contains the barcode number of a sample
     */
    private String barcode;


    /**
     * Creates a sample, receiving by parameter the lab order of a test.
     * Checks all parameters rules to see if the inputted data is valid.
     *
     * @param labOrder The lab order
     */
    public Sample(LabOrder labOrder) throws OutputException, BarcodeException {
        super(labOrder);

        this.barcode=createBarcode();
        imageIoWrite(makeUPCABarcode(this.barcode), this.barcode);

        //Criar barcode automatico e fazer verificacao se nao existe igual
    }

    /**
     * Counts all the samples already on the system +1 (starts on 1) to generate the sequential barcode number
     */
    public String createBarcode(){

        List<Test> tests=App.getInstance().getCompany().getTestStore().getTests();
        int c=1;
        for(Test testss : tests){
            for (Sample samples : testss.getSample()) {
                c++;
                }
            }

            DecimalFormat df = new DecimalFormat("00000000000");
        return df.format(c);
    }

    public static BufferedImage makeUPCABarcode(String barcodeText) throws BarcodeException, OutputException, BarcodeException {
        Barcode barcode = BarcodeFactory.createUPCA(barcodeText);
        barcode.setPreferredBarHeight(150);
        return BarcodeImageHandler.getImage(barcode);
    }

    public static void imageIoWrite(BufferedImage doneImage, String filename) {
        try {
            File outputfile = new File(filename+".jpg");
            ImageIO.write(doneImage, "jpg", outputfile);
        } catch (IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
        System.out.println("Images were written succesfully.");
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
    public String getBarcode() {
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
