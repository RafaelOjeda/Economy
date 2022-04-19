package person;

import bank.BankAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PersonProfile {
    private String firstName;
    private String lastName;
    private String birthDate;
    private int socialSecurity;

    public static HashMap<String, PersonProfile> peopleProfiles = new HashMap<>();
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    /*
     * Make it so it adds a random 4 digit number on the name as part of an ID in the key of the HashMap.
     * IE: Rafael#2121
     */

    public PersonProfile() {
        firstName = "None";
        lastName = "None";
        birthDate = "None";
        socialSecurity = -1;

        peopleProfiles.put(this.getFirstName(), this);
    }

    public PersonProfile(String firstName) {
        this.firstName = firstName;
        socialSecurityGen();

        peopleProfiles.put(firstName, this);
    }

    public PersonProfile(String firstName, String lastName) {
        this(firstName);
        this.lastName = lastName;
        socialSecurityGen();

        peopleProfiles.put(firstName, this);
    }

    public PersonProfile(String firstName, String lastName, String birthDate) {
        this(firstName, lastName);
        this.birthDate = birthDate;
        socialSecurityGen();

        peopleProfiles.put(firstName, this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

        peopleProfiles.put(firstName, this);
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

    public void setBankAccounts(Boolean addRemove, BankAccount aBankAccount) {
        if (addRemove) { // True means add a bank account to the ArrayList
            if (bankAccounts.contains(aBankAccount)) {
                System.out.println("Bank account already in wallet.");
            } else {
                bankAccounts.add(aBankAccount);
            }
        } else {
            if (!bankAccounts.contains(aBankAccount)) {
                System.out.println("Bank Account not in the wallet of " + firstName);
            } else {
                bankAccounts.remove(aBankAccount);
            }
        }
    }
}
