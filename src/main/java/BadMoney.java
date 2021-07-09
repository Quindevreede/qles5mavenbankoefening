import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;


public class BadMoney {

    public static void main(String[] args) {
        // Example 1

        BigDecimal  b11 = new BigDecimal(67891);
        BigDecimal  b21 = new BigDecimal("67891.000");

        if (b11.compareTo(b21) == 0) {
            System.out.println(b11 + " and " + b21 + " are equal.");
        }
        else if (b11.compareTo(b21) == 1) {
            System.out.println(b11 + " is greater than " + b21 + ".");
        }
        else {
            System.out.println(b11 + " is lesser than " + b21 + ".");
        }

        BigDecimal originalPrice1 = new BigDecimal("400000.00");
        BigDecimal reducedPrice1;
        BigDecimal discount1;

        try {
            reducedPrice1 = originalPrice1.subtract(BigDecimal.valueOf(0.05));
            discount1 = originalPrice1.subtract(reducedPrice1);
            System.out.println("-goed- De echte korting is: " + discount1);
        } catch (ArithmeticException e) {
            System.out.println("discount exception");
        }
        float originalPrice = 400000.00f;
        // to make the price more attractive, we'll reduce it to $399999.95
        float reducedPrice = originalPrice - 0.05f;
        float discount = originalPrice - reducedPrice;
        // Display discount amount
        System.out.println("-fout- De korting is: " + discount);

        // Example 2
        // The amount you have in the bank: $12,345,678.12
        BigDecimal moneyInBank1 = new BigDecimal("12345678.12");
        float moneyInBank = 12345678.12f;
        int count;    // count number of iterations
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.GERMANY);  // for output formatting.

        System.out.println("-goed- BigDecimal aantal geld in de bank: "
                + fmt.format(moneyInBank1) + ".");

        // Display the original amount
        System.out.println("-fout- Originele aantal geld in de bank: "
                + fmt.format(moneyInBank) + ".");

        // Add a dime to the principal a thousand times
        BigDecimal end = BigDecimal.valueOf(1000);
        for (BigDecimal i = BigDecimal.ONE; i.compareTo(end) < 0; i = i.add(BigDecimal.ONE)) {
            moneyInBank1 = moneyInBank1.add(BigDecimal.valueOf(.10));
        }
        // The result should be 100 dollars larger.
        System.out.println("-goed- Het Bigdecimal aantal geld in de bank: "
                + fmt.format(moneyInBank1) + ".");


            // Add a dime to the principal a thousand times
            for (count = 1; count <= 1000; count = count + 1) {
                moneyInBank = moneyInBank + .10f;
            }

            // The result should be 100 dollars larger.
            System.out.println("-fout- Het nieuwe aantal geld in de bank: "
                    + fmt.format(moneyInBank) + ".");


            BigDecimal itemPrice = new BigDecimal("4.35");
            BigDecimal a = itemPrice.multiply(BigDecimal.valueOf(100));
            int b = a.intValue();
            System.out.println("-goed- BigDecimal to INT Uitkomst van de berekening: " + b);

            // Example 3
            double floatNumber = 4.35;
            int integerNumber = (int) (100 * floatNumber);
            System.out.println("-fout- Uitkomst van de berekening: " + integerNumber);

        }
}
