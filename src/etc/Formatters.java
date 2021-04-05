package etc;

import etc.exception.invalid_input_exception.InvalidCpfInputException;
import etc.exception.invalid_input_exception.InvalidDateException;
import etc.exception.invalid_input_exception.InvalidIdentityException;

import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Formatters {
    public static NumberFormatter moneyFormat() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        format.setParseIntegerOnly(false);

        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setMinimum(0.0);
        formatter.setMaximum(10000.0);
        formatter.setAllowsInvalid(false);
        formatter.setOverwriteMode(true);

        return formatter;
    }

    public static MaskFormatter cpfFormat() throws InvalidCpfInputException {
        try {
            return new MaskFormatter("###.###.###-##");
        } catch (ParseException e) {
            throw new InvalidCpfInputException();
        }
    }

    public static MaskFormatter identidadeFormat() throws InvalidIdentityException {
        try {
            return new MaskFormatter("##.###.###");
        } catch (ParseException e) {
            throw new InvalidIdentityException();
        }
    }

    public static MaskFormatter dateFormat() throws InvalidDateException {
        try {
            return new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            throw new InvalidDateException();
        }
    }

    public static String dateToLocalString(Date date) {
        if (date == null)
            return "";

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }
}
