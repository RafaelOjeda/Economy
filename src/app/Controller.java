package app;

import bank.*;
import person.PersonProfile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
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

                // They are not an existing user create a new user object and store it on the .TXT
                if (existingUserQuestion.equals("0")) {


                    System.out.print("Enter your first name: ");
                    String firstNamePP = scanner.nextLine().toLowerCase();
                    System.out.println();

                    System.out.print("Enter your last name: ");
                    String lastNamePP = scanner.nextLine().toLowerCase();

                    System.out.print("Enter your birth day (MM/DD/YYYY): ");
                    String birthdatePP = scanner.nextLine().toLowerCase();

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

                    // ENDS CREATION OF USER MENU OPTION
                } else { // They are an existing user ask them for their username.

                    System.out.println("What is your userID? (User#0000)");

                    String userIDInput = scanner.nextLine();

                    try {
                        userIDInput.replaceAll(" ", ""); // Removes any unnecessary spaces.

                        final String fileLocation = "./Data/userProfiles.txt";

                        BufferedReader br = new BufferedReader(new FileReader(fileLocation));

                        String currentLine;

                        while ((currentLine = br.readLine()) != null) {

                            String[] tokens = currentLine.split(",");

                            if (tokens[0].equals(userIDInput.toLowerCase())) {
                                System.out.println("User found welcome. " + tokens[0]);
                            }

                        }
                    } catch (IOException e) {

                        e.printStackTrace();

                    }


                    /*
                     * If they are an existing user ask them for their userID. ie "Raf#0000"
                     * Within do-while create a for loop through all lines within the .TXT file and look for the id.
                     * If the user is found exit do-while loop. Else ask again.
                     *
                     * When found display that users information in full.
                     */

                }

            } else if (managerQuestion.equalsIgnoreCase("Q")) { // QUIT
                return;

            }

        } while (!scanner.nextLine().equalsIgnoreCase("STOP"));

    }
}
