package app;

import person.PersonProfile;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.*;

import java.util.Scanner;

public class Controller {

    public static void main(String[] args) throws IOException {

        /*
         * Skeleton of every out panel.
         * The mainFrame consists of a CardLayout.
         * Every direct child panel has a GridBagLayout structure.
         */

        JFrame mainFrame = new JFrame("Banking System");
        mainFrame.setLayout(new CardLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        // mainMenuCard
        JPanel mainMenuCard = new JPanel();

        mainMenuCard.setLayout(new GridBagLayout());
        JLabel welcomeTitleLabel = new JLabel("Welcome to the Global Bank");
        JButton newUserButton = new JButton("New User");
        JButton existingUserButton = new JButton("Existing User");
        JLabel estLabel = new JLabel("Est. 2022");

        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 5;
        welcomeTitleLabel.setFont(new Font("Serif", Font.BOLD, 40));
        mainMenuCard.add(welcomeTitleLabel, gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        mainMenuCard.add(newUserButton, gbc);

        gbc.gridy = 2;
        gbc.gridx = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        mainMenuCard.add(existingUserButton, gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.gridheight = 2;
        gbc.gridwidth = 5;
        mainMenuCard.add(estLabel, gbc);

        mainFrame.add(mainMenuCard);
        mainMenuCard.setVisible(true);
        //End of mainMenuCard

        // newUserCard
        JPanel newUserCard = new JPanel();

        newUserCard.setLayout(new GridBagLayout());

        mainFrame.add(newUserCard);
        // End of newUserCard

        // existingUserCard
        JPanel existingUserCard = new JPanel();

        existingUserCard.setLayout(new GridBagLayout());

        mainFrame.add(existingUserCard);
        // end of existingUserCard


        mainFrame.setSize(new Dimension(650,350));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel welcomePanel = new JPanel(new GridBagLayout());
        mainFrame.add(welcomePanel);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel welcomeLabel = new JLabel("Are you a guest or a manager?");
        JButton guestButton = new JButton("Guest");
        JButton managerButton = new JButton("Manager");

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        welcomePanel.add(welcomeLabel, gbc);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        welcomePanel.add(guestButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        welcomePanel.add(managerButton, gbc);


        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
//        managerQuestion();
//        startMenu();

    }
    public static String managerQuestion() {

        Scanner scanner = new Scanner(System.in);

        String managerQuestion;
        do {
            System.out.println("Type 'Q' at any time to quit menu.");
            System.out.println("Are you a manager?");
            System.out.print("'1' for yes '0' for no >> ");
            managerQuestion = scanner.nextLine();
        } while (!managerQuestion.equals("1") && !managerQuestion.equals("0") && !managerQuestion.equalsIgnoreCase("Q"));

        return managerQuestion;
    }

    public static void startMenu() throws IOException {

        final String userProfilesFile = "Data/userProfiles.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter(userProfilesFile, true));

        Scanner scanner = new Scanner(System.in);

        do {

            managerQuestion();

            if (managerQuestion().equals("1")) { // MANAGER MENU
                // managerMenu();
                System.out.println("HELLO!!!");

            } else if (managerQuestion().equals("0")) { // REGULAR USER MENU
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

                    } // END OF SEARCH OF EXISTING USER.


                    /*
                     * If they are an existing user ask them for their userID. ie "Raf#0000"
                     * Within do-while create a for loop through all lines within the .TXT file and look for the id.
                     * If the user is found exit do-while loop. Else ask again.
                     *
                     * When found display that users information in full.
                     */

                }

            } else if (managerQuestion().equalsIgnoreCase("Q")) { // QUIT
                return;

            }

        } while (!scanner.nextLine().equalsIgnoreCase("STOP"));

    }
}
