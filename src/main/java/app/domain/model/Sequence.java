package app.domain.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sequence {
    private Date date;

    private int number;

    public Sequence(Date date, int number) throws ParseException {

        this.date=date;
        this.number=number;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "date=" + date +
                ", number=" + number +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public int getNumber() {
        return number;
    }
}
