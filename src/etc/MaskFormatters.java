package etc;

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

    public static MaskFormatter cpfFormat() throws ParseException {
        return new MaskFormatter("###.###.###-##");
    }

    public static MaskFormatter dataFormat() throws ParseException {
        return new MaskFormatter("##/##/####");
    }
}
