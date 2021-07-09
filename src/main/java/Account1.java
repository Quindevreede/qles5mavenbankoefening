import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Account is a bank account with basic services for deposit,
 * withdrawal, and interest.
 */
public class Account1 {


    private static final Locale COUNTRY_CODE = Locale.ITALY;

    private static final BigDecimal INTEREST_RATE = BigDecimal.valueOf(0.045);  // interest rate of 4.5%

    private long accountNumber;
    private BigDecimal balance;
    public final String name;


    /**
     * Sets up the account by defining its owner, account number,
     * and initial balance.
     * @param owner name of account holder
     * @param account the account number, an identifier for the account
     * @param initial the initial amount of money in the account.
     */
    public Account1(String owner, long account,BigDecimal initial) {
        name = owner;
        accountNumber = account;
        balance = initial;
    }

    /**
     *  Deposit the specified amount into the account.
     *  @param amount value to be added to the balance
     *  @return true if amount is non-negative, false if amount
     *  is negative; indicates balance was not changed.
     */

    public boolean deposit(BigDecimal amount) {
        //amount = new BigDecimal(67891);
        BigDecimal zero = new BigDecimal("0");
        boolean result = true;
        if (amount.compareTo(zero) == -1) {
            result = false;
            System.out.println("Balance not changed due to a negative deposit");
        } else {
            balance = balance.add(amount);
        }
        return result;
    }

/*    public boolean deposit(float amount) {
        boolean result = true;
        // is amount invalid?
        if (amount < 0) {
            result = false;
        }
        else {
            balance = balance + amount;
        }

        return result;
    }

 */

    /**
     *  Withdraw the specified amount from the account,
     *  unless amount is negative, fee is negative, or
     *  amount exceeds current balance.
     *  @param amount value to be deducted from the balance
     *  @param fee the transaction fee debited from the account
     *  @return true if transaction was successful, false otherwise;
     *
     *  Toevoeging Nick:
     *  Na het draaien van givenEnoughBalanceForWithdrawlAccountCanGoNegativeWithFee() vonden we een bug
     *  in deze methode. Daarom is de methode aangepast.
     */
    public boolean withdraw(BigDecimal amount, BigDecimal fee) {

        boolean isValid = isValidWithdrawl(amount, fee);
        if (isValid) {
            //a = a.add(b);
            amount = amount.add(fee);
            balance = balance.subtract(amount);
        }
        return isValid;
    }

    /* Determine if withdrawal parameters are valid
    private boolean isValidWithdrawl(BigDecimal amount, BigDecimal fee) {
        BigDecimal zero1 = new BigDecimal("0");
        return amount.compareTo(zero1) == 0 || amount.compareTo(zero1) == 1 && fee.compareTo(zero1) == 0 || fee.compareTo(zero1) == 1 && amount.compareTo(balance) ==-1;
    }
    */
    private boolean isValidWithdrawl(BigDecimal amount, BigDecimal fee) {
    BigDecimal zero1 = new BigDecimal(0);
    return amount.compareTo(zero1) == 1 && fee.compareTo(zero1) == 1 && amount.compareTo(balance) == -1;
    }

    /**
     *  Adds interest to the account.
     */
    public void addInterest() {
        balance = balance.add((balance.multiply(INTEREST_RATE)));
    }

    /**
     * Accessor to the current balance of the account.
     * @return the current balance of the account.
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     *  Accessor to the account number.
     * @return the account number.
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     *  Returns a one-line description of the account as a string.
     *  @return formatted account information
     */
    public String toString() {
        return (accountNumber + "\t" + name + "\t" + localStyleForeignFormat(COUNTRY_CODE).format(balance));

    }

    public static NumberFormat localStyleForeignFormat(Locale locale) {
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        if (format instanceof DecimalFormat) {
            DecimalFormat df = (DecimalFormat) format;
            // use local/default decimal symbols with original currency symbol
            DecimalFormatSymbols dfs = new DecimalFormat().getDecimalFormatSymbols();
            dfs.setCurrency(df.getCurrency());
            df.setDecimalFormatSymbols(dfs);
        }
        return format;
    }
}
