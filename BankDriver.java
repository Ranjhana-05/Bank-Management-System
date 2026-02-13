import java.util.ArrayList;
import java.util.Scanner;

public class BankDriver {

    static ArrayList<Bank> accounts = new ArrayList<>();

    public static Bank findAccount(long accNo) {
        for (Bank b : accounts) {
            if (b.getAccountNumber() == accNo) {
                return b;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    long accNo = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();

                    accounts.add(new Bank(accNo, name));
                    System.out.println("Account created successfully.");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextLong();

                    Bank depositAcc = findAccount(accNo);

                    if (depositAcc != null) {
                        System.out.print("Enter amount: ");
                        double amt = sc.nextDouble();
                        depositAcc.deposit(amt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextLong();

                    Bank withdrawAcc = findAccount(accNo);

                    if (withdrawAcc != null) {
                        System.out.print("Enter amount: ");
                        double amt = sc.nextDouble();
                        withdrawAcc.withdraw(amt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextLong();

                    Bank checkAcc = findAccount(accNo);

                    if (checkAcc != null) {
                        System.out.println("Balance: " + checkAcc.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
