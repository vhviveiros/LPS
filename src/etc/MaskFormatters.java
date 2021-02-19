package etc;

import etc.exception.invalid_input_exception.InvalidCpfInputException;
import etc.exception.invalid_input_exception.InvalidDateException;
import etc.exception.invalid_input_exception.InvalididentityException;

import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class MaskFormatters {
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

    public static MaskFormatter identidadeFormat() throws InvalididentityException {
        try {
            return new MaskFormatter("##.###.###");
        } catch (ParseException e) {
            throw new InvalididentityException();
        }
    }

    public static MaskFormatter dateFormat() throws InvalidDateException {
        try {
            return new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            throw new InvalidDateException();
        }
    }
}
