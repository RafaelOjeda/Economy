package bank;
import java.util.Random;
import person.PersonProfile;
public class BankAccount {

    String bankAccountHolder;
    private double checkingsBalance;
    private double savingsBalance;
    private String bankAccountNum;

    public BankAccount () {
        bankAccountHolder = "None";
        checkingsBalance = 0.00;
        savingsBalance = 0.00;

        createBankAccountNumber();
    }

    public BankAccount (PersonProfile bankAccountHolder) {
        this.bankAccountHolder = bankAccountHolder.getFirstName() + " " + bankAccountHolder.getLastName();

        checkingsBalance = 0.00;
        savingsBalance = 0.00;

        createBankAccountNumber();
    }

    private void createBankAccountNumber() {
        Random accountNumberRandom = new Random();

        int accountNumGen = accountNumberRandom.nextInt(0,999999999);
        bankAccountNum = "U" + accountNumGen;
    }

    public String getBankAccountNumber() {
        return bankAccountNum;
    }
}
