/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;

abstract class BankAccount {
    protected String accNo;
    protected double balance;

    public BankAccount(String accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    public abstract void withdraw(double amt);

    public double getBalance() {
        return balance;
    }
}

// Savings Account
class SavingsAccount extends BankAccount {

    public SavingsAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public void withdraw(double amt) {
        if (amt <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
        } else if (amt > balance) {
            System.out.println("Error: Insufficient Funds. Savings cannot go below 0.");
        } else {
            balance -= amt;
            System.out.println("Withdrawal successful.");
        }
    }
}

// Current Account
class CurrentAccount extends BankAccount {

    private double overdraftLimit = 1000.0;

    public CurrentAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public void withdraw(double amt) {
        if (amt <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
        } else if (amt > balance + overdraftLimit) {
            System.out.println("Error: Overdraft limit exceeded.");
        } else {
            balance -= amt;
            System.out.println("Withdrawal successful.");
        }
    }
}

// Main class
public class Problem3_BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Select Account Type (1-Savings, 2-Current): ");
        int choice = sc.nextInt();

        System.out.print("Enter Acc No and Initial Balance: ");
        String num = sc.next();
        double bal = sc.nextDouble();

        BankAccount account = (choice == 1)
                ? new SavingsAccount(num, bal)
                : new CurrentAccount(num, bal);

        System.out.print("Enter withdrawal amount: ");
        double amt = sc.nextDouble();

        account.withdraw(amt);

        System.out.println("Remaining Balance: " + account.getBalance());

        sc.close();
    }
}