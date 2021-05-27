package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class Sample{
    /**
     * int that contains the barcode number of a sample
     */
    private BarcodeCreate barcode;




    /**
     * Creates a sample, receiving by parameter the lab order of a test.
     * Checks all parameters rules to see if the inputted data is valid.
     *
     */
    public Sample(Company c) throws BarcodeException, IllegalAccessException, InstantiationException, ClassNotFoundException, OutputException {

        this.barcode=getBarcodecreator().makeUPCABarcode(createBarcode(c));




        //Criar barcode automatico e fazer verificacao se nao existe igual
    }

    /**
     * Counts all the samples already on the system +1 (starts on 1) to generate the sequential barcode number
     */
    public String createBarcode(Company company){

        List<Test> tests=company.getTestStore().getTests();
        int c=1;
        for(Test testss : tests){
            for (Sample ignored : testss.getSample()) {
                c++;
                }
            }

            DecimalFormat df = new DecimalFormat("00000000000");
        return df.format(c);
    }

    public ApiBarcode getBarcodecreator() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Properties props = App.getInstance().getprops();
        String classAux = props.getProperty("Domain.BarcodeAdapter.Class");
        Class<?> oClass = Class.forName(classAux);
        ApiBarcode api = (ApiBarcode) oClass.newInstance();
        return api;

    }

    public BufferedImage barcodeImage(BarcodeCreate barcode) throws OutputException {


        return BarcodeImageHandler.getImage((Barcode) barcode.getBarcode());
    }

    public void imageIoWrite(BufferedImage doneImage, String filename) {
        try {
            String pwd = System.getProperty("user.dir");


            File barcodes = new File(pwd + "\\src\\main\\barcodes");
            if (!barcodes.exists()) {
                barcodes.mkdirs();
            }
            File outputfile = new File(pwd+"\\src\\main\\barcodes\\"+filename+".jpg");
            ImageIO.write(doneImage, "jpg", outputfile);
        } catch (IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
        System.out.println("Images were written succesfully.");
    }

    public void showBarcodes(BarcodeCreate barcode){

        JFrame frame = new JFrame();
        frame.getContentPane().add((Component) barcode.getBarcode());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setLocation(500, 500);
        frame.setVisible(true);

    }
    /**
     * Returns the textual description of a sample.
     * @return characteristics of a sample.
     */
    @Override
    public String toString() {
        return "barcode number='" + barcode.getBarcodeNumber() + '\'';
    }
    /**
     * Returns the barcode number of a sample.
     * @return the barcode number of a sample.
     */
    public BarcodeCreate getBarcode() {
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
