package app;

import bank.*;
import person.PersonProfile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) throws IOException {

        final String userProfilesFile = "Data/userProfiles.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter(userProfilesFile, true));

        Scanner scanner = new Scanner(System.in);
        // Make it so program runs through Terminal inputs.
        do {

            // PP = PersonProfile

            System.out.print("Enter your first name: ");
            String firstNamePP = scanner.nextLine();
            System.out.println();

            System.out.print("Enter your last name: ");
            String lastNamePP = scanner.nextLine();

            System.out.print("Enter your birth day (MM/DD/YYYY): ");
            String birthdatePP = scanner.nextLine();

            PersonProfile personProfile = new PersonProfile(firstNamePP, lastNamePP, birthdatePP);

            personProfile.displayInfo();
            /*STORE EVERYTHING ON A .TXT FILE
             * System.out.println("-------------------------------");
             * System.out.println();
             * System.out.println("ALL INFORMATION ENTERED HAS BEEN SAVED");
             * System.out.println();
             * System.out.println("-------------------------------");
             *
             * Create a BankAccount for that user and set it to 0
             * While loop asking if they want a loan.
             */

            // ADDS ALL INFO ENTERED ONTO THE USERPROFILES.txt file.
            writer.newLine();
            writer.write(firstNamePP + "#" + personProfile.getPersonID() + "," + lastNamePP + "," + birthdatePP + "," + personProfile.getSocialSecurity());

            System.out.println("Do you which to continue? (Type 'stop' to stop)");
        } while (!scanner.nextLine().equalsIgnoreCase("STOP"));
        writer.close();


//        PersonProfile reom = new PersonProfile("REOM", "Ojeda", "12/11/1999");
//
//        BankAccount reomBankAccount = new BankAccount();
//
//        System.out.println(reom.getFirstName() + " " + reom.getLastName() + " " + reom.getBirthDate()
//                + " " + reomBankAccount.getBankAccountNumber());
//
//        Loan schoolLoan = new Loan(reom, reomBankAccount, 10);
//        schoolLoan.loanInfo();
//
//        reom.getBankAccounts().add(reomBankAccount);
    }
}
