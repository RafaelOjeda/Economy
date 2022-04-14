package person;

import bank.BankAccount;

import java.util.ArrayList;
import java.util.Random;

public class PersonProfile {
    private String firstName;
    private String lastName;
    private String birthDate;
    private int socialSecurity;

    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public PersonProfile() {
        firstName = "None";
        lastName = "None";
        birthDate = "None";
        socialSecurity = -1;
    }

    public PersonProfile(String firstName) {
        this.firstName = firstName;
        socialSecurityGen();
    }

    public PersonProfile(String firstName, String lastName) {
        this(firstName);
        this.lastName = lastName;
        socialSecurityGen();
    }

    public PersonProfile(String firstName, String lastName, String birthDate) {
        this(firstName, lastName);
        this.birthDate = birthDate;
        socialSecurityGen();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    private void socialSecurityGen() {
        Random socialSecurityRandom = new Random();
        socialSecurity = socialSecurityRandom.nextInt(0, 999999999);
    }

    public int getSocialSecurity() {
        return socialSecurity;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
