package bank;

import person.PersonProfile;
import bank.BankAccount;
public class Loan {
    private double loanAmount;
    private double interest;
    private PersonProfile person;

    public Loan(PersonProfile person, BankAccount accountName, double loanAmount) {

        this.loanAmount = loanAmount;
        this.person = person;

        interest = loanAmount * 1.08;
    }

    public void setLoanAmount(double loanAmount, double interest) {
        this.loanAmount = loanAmount;
        this.interest = interest;
    }
    public double getLoanAmount() {
        return loanAmount;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
    public double getInterest() {
        return interest;
    }

    public void payLoan(int payAmount) {
        if (payAmount > loanAmount) {
            System.out.println("You are paying more than what you owe.");
        } else if (loanAmount == 0) {
            System.out.println("You do not owe anything.");
        }
        else {
            loanAmount = loanAmount - payAmount;
        }

    }

    public void loanInfo() {
        System.out.println("----------=Loan Info=----------");
        System.out.printf("Name: %s\n", person.getFirstName());
        System.out.printf("Loan to Pay: $%.2f\n", loanAmount);
        System.out.printf("Loan After Interest: $%.2f\n", interest);
        System.out.println("===============================");
    }
}
