package bank;
import java.util.ArrayList;
import java.util.Random;
import person.PersonProfile;
public class BankAccount {

    String bankAccountHolder;
    private double checkingsBalance;
    private double savingsBalance;
    private String bankAccountNum;

    private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G",
                                 "H", "I", "J", "K", "L", "M", "N",
                                 "O", "P", "Q", "R", "S", "T", "U",
                                 "V", "W", "X", "Y", "Z"};

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
        Random rndGen = new Random();



        int accountNumGen = rndGen.nextInt(0,999999999);
        bankAccountNum = alphabet[rndGen.nextInt(alphabet.length)] + accountNumGen;
    }

    public String getBankAccountNumber() {
        return bankAccountNum;
    }
}
