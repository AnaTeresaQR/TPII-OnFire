package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class in charge of manage de format date
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public class DateFormatString {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Method to get the format date.
     *
     * @param date to format
     * @return a date format.
     */
    public String getDateFormat(Date date) {
        return dateFormat.format(date);
    }

    /**
     * Method to get a String into Calendar.
     *
     * @param date, receives a String to be parsed
     * @return a calendar date
     * @throws java.text.ParseException problems with parse
     */
    public Calendar getCalendarFormat(String date) throws ParseException {
        Date newDate = dateFormat.parse(date);
        Calendar calendar = dateFormat.getCalendar();
        return calendar;
    }

}
