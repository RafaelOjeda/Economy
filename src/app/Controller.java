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

    public static void main(String[] args) throws IOException{
        startMenu();

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

    public static void startMenu() throws IOException{
        final String userProfilesFile = "Data/userProfiles.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter(userProfilesFile, true));

        Scanner scanner = new Scanner(System.in);
        // Make it so program runs through Terminal inputs.
        do {
            // PP = PersonProfile
            String managerQuestion;
            do {
                System.out.println("Type 'Q' at any time to quit menu.");
                System.out.println("Are you a manager?");
                System.out.print("'1' for yes '0' for no >> ");
                managerQuestion = scanner.nextLine();
            } while (!managerQuestion.equals("1") && !managerQuestion.equals("0") && !managerQuestion.equalsIgnoreCase("Q"));

            if (managerQuestion.equals("1")) { // MANAGER MENU
                // managerMenu();
                System.out.println("HELLO!!!");

            } else if (managerQuestion.equals("0")) { // REGULAR USER MENU
                // userMenu()
                System.out.println("HELLO");
                String existingUserQuestion;

                do {
                  System.out.println("Are you an existing user?");
                  System.out.print("'1' for yes '0' for no >> ");

                  existingUserQuestion = scanner.nextLine(); // "1 for YES 0 for NO"

                } while (!existingUserQuestion.equals("1") && !existingUserQuestion.equals("0"));

                if (existingUserQuestion.equals("0")) {
                    // They are not an existing user create a new user object and store it on the .TXT

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

                    writer.close();
                } else { // They are an existing user ask them for their username.

                }

            } else if (managerQuestion.equalsIgnoreCase("Q")) { // QUIT
                return;

            }

        } while (!scanner.nextLine().equalsIgnoreCase("STOP"));

    }
}
