package app.domain.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sequence {
    /**
     * Date that contains the date
     */
    private Date date;
    /**
     * Int that contains the nuumber
     */
    private int number;

    public Sequence(Date date, int number) throws ParseException {

        this.date=date;
        this.number=number;
    }

    @Override
    public String toString() {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        return "Sequence{" +
                "date=" + DateFor.format(date) +
                ", number=" + number +
                '}';
    }
    /**
     * Returns the date.
     * @return the date.
     */
    public Date getDate() {
        return date;
    }
    /**
     * Returns the number .
     * @return the number.
     */
    public int getNumber() {
        return number;
    }
}
