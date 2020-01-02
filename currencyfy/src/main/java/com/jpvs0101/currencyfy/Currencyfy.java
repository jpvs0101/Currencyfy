package com.jpvs0101.currencyfy;

import androidx.annotation.NonNull;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Converts number to readable currency format. Easy, error free & highly compatible!
 *
 * @author Jayprakash
 */
public class Currencyfy {

    // Non breaking space character
    private static final String NBSP_CHAR = Character.toString((char) 160);

    private static final String SPACE = " ";


    private Currencyfy() {
    }

    /**
     * <pre>
     *
     * Converts the given number to easily readable currency format.
     * Examples:
     *      currencyfy (500000) ------------------------> ₹ 5,00,000.00
     *      currencyfy (7200) --------------------------> ₹ 7,200.00
     * </pre>
     *
     * @param number Number you want to format. <br>
     * @return Formatted currency format. Refer description for examples.
     */
    public static String currencyfy(final double number) {
        return currencyfy(number, true, true);
    }

    public static String currencyfy(final Locale locale, final double number) {
        return currencyfy(locale, number, true, true);
    }

    /**
     * <pre>
     *
     * Converts the given number to easily readable currency format.
     *
     * Examples:
     *      currencyfy (500000, false) -----------------> ₹ 5,00,000
     *      currencyfy (500000, true) ------------------> ₹ 5,00,000.00
     *
     * </pre>
     *
     * @param number   Number you want to format. <br>
     * @param fraction If you want fraction, pass true. If you want to hide fraction, pass false.
     *                 Default value is true. Default fraction digits are two.<br>
     * @return Formatted currency format. Refer description for examples.
     */
    public static String currencyfy(final double number, final boolean fraction) {
        return currencyfy(number, fraction, true);
    }

    public static String currencyfy(final Locale locale, final double number,
                                    final boolean fraction) {
        return currencyfy(locale, number, fraction, true);
    }

    /**
     * <pre>
     *
     * Converts the given number to easily readable currency format.
     *
     * Examples:
     *      currencyfy (500000, false, false) ----------> 5,00,000
     *      currencyfy (500000, true, false) -----------> 5,00,000.00
     *      currencyfy (500000, false, true) -----------> ₹ 5,00,000
     *      currencyfy (500000, true, true) ------------> ₹ 5,00,000.00
     * </pre>
     *
     * @param number         Number you want to format. <br>
     * @param fraction       If you want fraction, pass true. If you want to hide fraction, pass false.
     *                       Default value is true. Default fraction digits are two.<br>
     * @param currencySymbol If you want currency symbol, pass true. If you want to hide
     *                       currency symbol, pass false. Default value is true. <br>
     * @return Formatted currency format. Refer description for examples.
     */
    public static String currencyfy(final double number, final boolean fraction,
                                    final boolean currencySymbol) {
        final Locale locale = Locale.getDefault(); // We use default locale if user not specified
        return currencyfy(locale, number, fraction, currencySymbol);
    }

    /**
     * <pre>
     *
     * Converts the given number to easily readable currency format.
     *
     * Examples:
     *      currencyfy (locale, 500000, false, false) ----------> 5,00,000
     *      currencyfy (locale, 500000, true, false) -----------> 5,00,000.00
     *      currencyfy (locale, 500000, false, true) -----------> ₹ 5,00,000
     *      currencyfy (locale, 500000, true, true) ------------> ₹ 5,00,000.00
     * </pre>
     *
     * @param locale         For fetching currency symbol & number format
     * @param number         Number you want to format. <br>
     * @param fraction       If you want fraction, pass true. If you want to hide fraction,
     *                       pass false. Default value is true. Default fraction digits are two.<br>
     * @param currencySymbol If you want currency symbol, pass true. If you want to hide
     *                       currency symbol, pass false.Default value is true. <br>
     * @return Formatted currency format. Refer description for examples.
     */
    public static String currencyfy(@NonNull final Locale locale, final double number,
                                    final boolean fraction, final boolean currencySymbol) {

        final NumberFormat nf = NumberFormat.getCurrencyInstance(locale);

        if (fraction) { // By default we set two fractions
            nf.setMinimumFractionDigits(2);
            nf.setMaximumFractionDigits(2);
        } else { // No fraction needed
            nf.setMaximumFractionDigits(0);
        }

        String currencyfied;
        if (currencySymbol) {
            currencyfied = nf.format(number);
            currencyfied = currencyfied.replace(NBSP_CHAR, "");
            final String symbol = Currency.getInstance(locale).getSymbol(locale);
            // We prefix/suffix (based on language direction) for prettiness
            final String spacedSymbol = TextUtilsCompat.getLayoutDirectionFromLocale(locale)
                    == ViewCompat.LAYOUT_DIRECTION_RTL ? SPACE.concat(symbol) : symbol.concat(SPACE);
            currencyfied = currencyfied.replace(symbol, spacedSymbol);

        } else { // Remove currency symbol
            final DecimalFormatSymbols decimalFormatSymbols
                    = ((DecimalFormat) nf).getDecimalFormatSymbols();
            decimalFormatSymbols.setCurrencySymbol("");
            ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);
            currencyfied = nf.format(number);
        }

        return currencyfied;

    }
}