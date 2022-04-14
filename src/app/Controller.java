package app;

import bank.*;
import person.PersonProfile;

public class Controller {

    public static void main(String[] args) {
        PersonProfile reom = new PersonProfile("REOM", "Ojeda", "12/11/1999");

        BankAccount reomBankAccount = new BankAccount();

        System.out.println(reom.getFirstName() + " " + reom.getLastName() + " " + reom.getBirthDate()
                + " " + reomBankAccount.getBankAccountNumber());

        Loan schoolLoan = new Loan(reom, 10);
        schoolLoan.loanInfo();
    }
}
