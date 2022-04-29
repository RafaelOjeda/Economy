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

    private int personID;

    public static HashMap<String, PersonProfile> peopleProfiles = new HashMap<>();
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    /*
     *  This Random object is used for generating a Social Security
     *  and an ID for the PersonProfile.
     */
    Random rndGen = new Random();



    public PersonProfile() {
        firstName = "None";
        lastName = "None";
        birthDate = "None";
        socialSecurity = -1;

        personID = rndGen.nextInt(1000, 9999);

        peopleProfiles.put(this.getFirstName() + "#" + personID, this);
    }

    public PersonProfile(String firstName) {
        this.firstName = firstName;
        socialSecurityGen();

        personID = rndGen.nextInt(1000, 9999);

        peopleProfiles.put(firstName, this);
    }

    public PersonProfile(String firstName, String lastName) {
        this(firstName);
        this.lastName = lastName;
        socialSecurityGen();

        personID = rndGen.nextInt(1000, 9999);

        peopleProfiles.put(firstName, this);
    }

    public PersonProfile(String firstName, String lastName, String birthDate) {
        this(firstName, lastName);
        this.birthDate = birthDate;
        socialSecurityGen();

        personID = rndGen.nextInt(1000, 9999);

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
        socialSecurity = rndGen.nextInt(0, 999999999);
    }

    public int getSocialSecurity() {
        return socialSecurity;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public int getPersonID() {
        return personID;
    }

    public void displayInfo() {
        System.out.println("-------------------------------------------");
        System.out.println("#" + personID + " " + firstName + " " + lastName + "'s \tProfile");
        System.out.println("-------------------------------------------");
        System.out.printf("Full Name: %s %s", firstName, lastName);
        System.out.println();
        System.out.println("DOB: " + birthDate);
        System.out.println("Social Security: " + socialSecurity);
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
