package sample;

import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DatePickerUtil {
    /** The date pattern that is used for conversion. Change as you wish. */
    private static final String DATE_PATTERN = "MM.dd.yyyy";

    /** The date formatter. */
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN);


    /**
     * Returns the given date as a well formatted String. The above defined
     * {@link DateUtil#DATE_PATTERN} is used.
     *
     * @param date the date to be returned as a string
     * @return formatted string
     */



    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    public LocalDate fromString(String string) {
        if (string != null && !string.isEmpty()) {
            return LocalDate.parse(string, DATE_FORMATTER);
        } else {
            return null;
        }
    }

    /**
     * Converts a String in the format of the defined {@link DateUtil#DATE_PATTERN}
     * to a {@link LocalDate} object.
     *
     * Returns null if the String could not be converted.
     *
     * @param dateString the date as String
     * @return the date object or null if it could not be converted
     */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Checks the String whether it is a valid date.
     *
     * @param dateString
     * @return true if the String is a valid date
     */
    public static boolean validDate(String dateString) {
        // Try to parse the String.
        return DateUtil.parse(dateString) != null;
    }

//    String pattern = "yyyy-MM-dd";

//    datePicker.setPromptText(pattern.toLowerCase());

//    datePicker.setConverter(new StringConverter<LocalDate>() {
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
//
//        @Override
//        public String toString(LocalDate date) {
//            if (date != null) {
//                return dateFormatter.format(date);
//            } else {
//                return "";
//            }
//        }
//
//        @Override
//        public LocalDate fromString(String string) {
//            if (string != null && !string.isEmpty()) {
//                return LocalDate.parse(string, dateFormatter);
//            } else {
//                return null;
//            }
//        }
//    });

}
